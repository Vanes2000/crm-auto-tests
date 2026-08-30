package crm.tests.precondition;

import com.codeborne.selenide.Selenide;
import crm.adapters.pages.PersonalPage;
import crm.checks.UrlChecks;
import crm.utils.DocumentType;
import crm.utils.NameGenerator;
import crm.utils.TestFile;
import crm.utils.TypeCitizenship;
import io.qameta.allure.Description;

import static com.codeborne.selenide.Condition.*;
import static crm.utils.NameGenerator.generateRandomBirthDate;

public class PreconditionTestPersonal {

    PersonalPage.EmployeeDataForm employeeDataForm = new PersonalPage.EmployeeDataForm();
    PersonalPage.EmployeeDocumentsForm employeeDocumentsForm = new PersonalPage.EmployeeDocumentsForm();
    PersonalPage.PersonalModal modal = new PersonalPage.PersonalModal();

    @Description("Переход в таблицу с добавленными сотрудниками после авторизации")
    public static void openStaffAdditionForm() {
        PersonalPage.MainPage.buttonHeaderHover.shouldBe(exist, visible).click();
        PersonalPage.MainPage.linkNoneRouter.shouldBe(exist, visible).click();
        UrlChecks.PersonalCreationChecks.checkPagePersonal();
    }

    @Description("Открытие формы добавления сотрудника")
    public static void openStaffAddForm() {
        PersonalPage.MainPage.buttonOutlinedTheme.shouldBe(exist, visible).click();
        UrlChecks.PersonalCreationChecks.checkPageAddPersonalForm();
        PersonalPage.MainPage.pText.shouldBe(exist, visible).shouldHave(exactText("Персонал"));
    }

    @Description("Заполнение основных данных сотрудника - Розница")
    public void fillEmployeeDataRetail() {
        String[] randomName = NameGenerator.generateRandomName();
        String firstName = randomName[0];
        String lastName = randomName[1];
        String middleName = randomName[2];

        employeeDataForm.fieldSurName.shouldBe(exist, visible).click();
        employeeDataForm.fieldSurName.setValue(lastName);
        employeeDataForm.fieldName.shouldBe(exist, visible).click();
        employeeDataForm.fieldName.setValue(firstName);
        employeeDataForm.fieldPatronymic.shouldBe(exist, visible).click();
        employeeDataForm.fieldPatronymic.setValue(middleName);
        employeeDataForm.fieldDateOfBirth.shouldBe(exist, visible).click();
        employeeDataForm.fieldDateOfBirth.setValue(generateRandomBirthDate());
        employeeDataForm.fieldTelephone.shouldBe(exist, visible).click();
        employeeDataForm.fieldTelephone.setValue("88887776655");
        employeeDataForm.fieldCitizenship.shouldBe(exist, visible).click();
    }

    @Description("Выбор гражданства")
    public void choosingCitizenship(TypeCitizenship typeCitizenship) {
        employeeDataForm.fieldCitizenship.shouldBe(exist, visible).click();
        typeCitizenship.getElement().shouldBe(exist, visible).click();
    }

    @Description("Заполнение основных данных сотрудника - Логистика")
    public void fillEmployeeDataLogistics() {
        String[] randomName = NameGenerator.generateRandomName();
        String firstName = randomName[0];
        String lastName = randomName[1];
        String middleName = randomName[2];

        employeeDataForm.fieldSurName.shouldBe(exist, visible).click();
        employeeDataForm.fieldSurName.setValue(lastName);
        employeeDataForm.fieldName.shouldBe(exist, visible).click();
        employeeDataForm.fieldName.setValue(firstName);
        employeeDataForm.fieldPatronymic.shouldBe(exist, visible).click();
        employeeDataForm.fieldPatronymic.setValue(middleName);
        employeeDataForm.fieldDateOfBirth.shouldBe(exist, visible).click();
        employeeDataForm.fieldDateOfBirth.setValue(generateRandomBirthDate());
        employeeDataForm.objectField.shouldBe(exist, visible).click();
        employeeDataForm.selectObject.shouldBe(exist, visible).click();
        employeeDataForm.form.doubleClick();
        employeeDataForm.form.doubleClick();
        employeeDataForm.fieldCitizenship.shouldBe(exist, visible).click();
    }

    @Description("Заполнение данных для трансфера")
    public void fillTransferModal() {
        modal.transferCheckBox.shouldBe(exist, visible).click();
        modal.addressField_A.shouldBe(exist, visible).click();
        modal.addressField_A.setValue("ул. Рязанова 163");
        modal.transferObjectFiled.shouldBe(exist, visible).click();
        modal.transferSelectObject.shouldBe(exist, visible).click();
        modal.transferSelectRegion.shouldBe(exist, visible);
        modal.localitySelect.shouldBe(exist, visible);
        modal.addressField_B.shouldBe(exist, visible).click();
        modal.addressField_B.setValue("ул. Гагаринская 49");
    }

    @Description("Ввод данных уже существующего линейщика")
    public void enterExistingEmployeeData() {
        employeeDataForm.fieldSurName.click();
        employeeDataForm.fieldSurName.setValue("Орлова");
        employeeDataForm.fieldName.click();
        employeeDataForm.fieldName.setValue("Варвара");
        employeeDataForm.fieldPatronymic.click();
        employeeDataForm.fieldPatronymic.setValue("Даниловна");
        employeeDataForm.fieldDateOfBirth.click();
        employeeDataForm.fieldDateOfBirth.setValue("22.04.1962");
        employeeDataForm.fieldTelephone.click();
        employeeDataForm.fieldTelephone.setValue("88887776655");
        choosingCitizenship(TypeCitizenship.RF);
        employeeDataForm.buttonSave.click();
    }

    @Description("Сохранение данных на первом этапе после заполнения данных сотрудника")
    public void SavingDataAfterInput() {
        employeeDataForm.buttonSave.shouldBe(exist, visible).click();
    }

    @Description("Проверка перехода на второй этап добавления сотрудника")
    public void verifyFirstStageTransition() {
        UrlChecks.PersonalCreationChecks.checkPageAddPersonalForm();
    }

    @Description("Добавление документа")
    public void addDocument(DocumentType type, TestFile file) {
        openDocumentForm();
        UrlChecks.PersonalCreationChecks.checkingAddDocumentForm();
        employeeDocumentsForm.divClickable.shouldBe(exist).uploadFromClasspath(file.getPathFile());
        clickSelectDocument();
        type.getElement().shouldBe(exist, visible).click();
        clickSaveDocument();
    }

    @Description("Клик по селекту для выбора документа")
    private void clickSelectDocument() {
        employeeDocumentsForm.divSelectSlot.shouldBe(exist, visible).click();
    }

    @Description("Открытие формы добавления документа")
    public void openDocumentForm() {
        employeeDocumentsForm.buttonAdd.shouldBe(exist, visible).click();
    }

    @Description("Клик по кнопке добавления документа")
    public void clickSaveDocument() {
        employeeDocumentsForm.buttonSaveDoc.shouldBe(exist, visible).click();
    }

    @Description("Добавление сотрудника в систему")
    public void AddPersonalSystem() {
        employeeDocumentsForm.buttonSaveDoc.shouldBe(exist, visible).click();
    }

    @Description("Обновление страницы")
    public void updatePage() {
        Selenide.refresh();
    }
}


