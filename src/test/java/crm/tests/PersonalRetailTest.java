package crm.tests;

import crm.adapters.pages.color.ColorPage;
import crm.adapters.pages.notifications.NotificationPage;
import crm.checks.UrlChecks;
import crm.tests.precondition.PreconditionTestPersonal;
import crm.utils.DocumentType;
import crm.utils.TestFile;
import crm.utils.TypeCitizenship;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class PersonalRetailTest extends BasedTest {

    @BeforeClass
    public void openAuth() {
        loginHelper.loginAsManagerRetail();
        UrlChecks.BaseChecks.checkPageRedirect();
        PreconditionTestPersonal.openStaffAdditionForm();
    }

    @Test(priority = 1, groups = {"system"})
    @Description("Добавление линейщика РФ с паспортом")
    public void failedUserAddition() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.fillEmployeeDataRetail();
        preconditions.choosingCitizenship(TypeCitizenship.RF);
        preconditions.SavingDataAfterInput();
        checkNotification.checkSaveNotification();
        preconditions.verifyFirstStageTransition();
        preconditions.addDocument(DocumentType.PASSPORT, TestFile.JPG);
        checkNotification.checkSaveNotification();
        UrlChecks.PersonalCreationChecks.checkPageAddPersonalForm();
        employeeDocumentsForm.spanContent.shouldBe(exist, visible).click();
        UrlChecks.PersonalCreationChecks.checkPagePersonal();
        checkNotification.checkSaveNotification();
    }

    @Test(priority = 2, groups = {"system"})
    @Description("Добавление линейщика тип гражданства: ЕАС")
    public void failedUserAddition2() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.fillEmployeeDataRetail();
        preconditions.choosingCitizenship(TypeCitizenship.Kyrgyzstan);
        preconditions.SavingDataAfterInput();
        checkNotification.checkSaveNotification();
        preconditions.verifyFirstStageTransition();
        preconditions.addDocument(DocumentType.PASSPORT, TestFile.JPG);
        checkNotification.checkSaveNotification();
        UrlChecks.PersonalCreationChecks.checkPageAddPersonalForm();
        employeeDocumentsForm.spanContent.shouldBe(exist, visible).click();
        UrlChecks.PersonalCreationChecks.checkPagePersonal();
        checkNotification.checkSaveNotification();
    }

    @Test(priority = 3, groups = {"system"})
    @Description("Добавление линейщика с гражданством: РФ с признаком без ДУЛ")
    public void addingALinemanWithoutRequiredDocuments() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.fillEmployeeDataRetail();
        preconditions.choosingCitizenship(TypeCitizenship.RF);
        employeeDataForm.checkBoxWithoutIdentificationDocuments.click();
        preconditions.SavingDataAfterInput();
        preconditions.verifyFirstStageTransition();
        employeeDocumentsForm.spanContent.click();
        UrlChecks.PersonalCreationChecks.checkPagePersonal();
        checkNotification.checkSaveNotification();
    }

    @Test(priority = 4, groups = {"system"})
    @Description("Добавление уже существующего линейщика")
    public void addingAnExistingEmployee() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.enterExistingEmployeeData();
        NotificationPage.notification
                .shouldBe(exist, visible)
                .shouldHave(exactText("Сотрудник уже есть в системе, перейти"));
        closeForm();
    }

    @Test(priority = 5, groups = {"system"})
    @Description("Добавление линейщика со всеми доступными признаками")
    public void addLinemanWithAllAvailableAttributes() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.fillEmployeeDataRetail();
        preconditions.choosingCitizenship(TypeCitizenship.RF);
        employeeDataForm.checkBoxEmploymentAvailable.click();
        employeeDataForm.checkBoxFullTime.click();
        employeeDataForm.nameFullTime.click();
        employeeDataForm.nameFullTime.setValue("Штатный");
        employeeDataForm.checkBoxWithoutIdentificationDocuments.click();
        preconditions.SavingDataAfterInput();
        checkNotification.checkSaveNotification();
        preconditions.verifyFirstStageTransition();
        employeeDocumentsForm.spanContent.click();
        UrlChecks.PersonalCreationChecks.checkPagePersonal();
        checkNotification.checkSaveNotification();
    }

    @Test(priority = 6, groups = {"validation form", "negative"})
    @Description("Проверка валидации полей обязательных к заполнению")
    public void validationOfRequiredFields() {
        PreconditionTestPersonal.openStaffAddForm();
        employeeDataForm.buttonSave.click();

        employeeErrorDataForm.surnameError.shouldBe(exist, visible);
        employeeColorIndicatorLocators.colorSurname.shouldBe(cssValue(ColorPage.COLOR, ColorPage.ERROR_COLOR));

        employeeErrorDataForm.nameError.shouldBe(exist, visible);
        employeeColorIndicatorLocators.colorName.shouldBe(cssValue(ColorPage.COLOR, ColorPage.ERROR_COLOR));

        employeeColorIndicatorLocators.colorPatronymic.shouldBe(cssValue(ColorPage.COLOR, ColorPage.DEFAUL_TCOLOR ));

        employeeErrorDataForm.dateOfBirthError.shouldBe(exist, visible);
        employeeColorIndicatorLocators.colorDateOfBirth.shouldBe(cssValue(ColorPage.COLOR, ColorPage.ERROR_COLOR));

        employeeColorIndicatorLocators.colorDirection.shouldBe(cssValue(ColorPage.COLOR, ColorPage.DEFAUL_TCOLOR ));

        employeeErrorDataForm.telephoneError.shouldBe(exist, visible);
        employeeColorIndicatorLocators.colorTelephone.shouldBe(cssValue(ColorPage.COLOR, ColorPage.ERROR_COLOR));

        employeeColorIndicatorLocators.colorAccess.shouldBe(cssValue(ColorPage.COLOR, ColorPage.DEFAUL_TCOLOR ));

        employeeErrorDataForm.citizenshipError.shouldBe(exist, visible);
        employeeColorIndicatorLocators.colorCitizenship.shouldBe(cssValue(ColorPage.COLOR, ColorPage.ERROR_COLOR));

        employeeColorIndicatorLocators.colorCheckBoxEmploymentAvailable.shouldBe(cssValue(ColorPage.COLOR, ColorPage.DEFAUL_TCOLOR ));

        employeeColorIndicatorLocators.colorCheckBoxFullTime.shouldBe(cssValue(ColorPage.COLOR, ColorPage.DEFAUL_TCOLOR ));

        employeeColorIndicatorLocators.colorCheckBoxWithoutIdentificationDocuments.shouldBe(cssValue(ColorPage.COLOR, ColorPage.DEFAUL_TCOLOR ));

        checkNotification.checkNotificationText();

        employeeDataForm.buttonCloseAddFrom.shouldBe(exist, visible).click();
    }

    @Test(priority = 7, groups = {"validation form", "negative"})
    @Description("Проверка валидации при добавлении линейщика без обязательных документов")
    public void validationCheckWhenAddingALineWorkerWithoutAnIDOrIdentificationDocuments() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.fillEmployeeDataRetail();
        preconditions.choosingCitizenship(TypeCitizenship.RF);
        preconditions.SavingDataAfterInput();
        preconditions.verifyFirstStageTransition();
        checkNotification.checkSaveNotification();
        employeeDocumentsForm.spanContent.click();
        NotificationPage.notification
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Необходимо приложить ID карту или паспорт"))
                .shouldBe(disappear, Duration.ofSeconds(15));
        closeForm();
    }

    @Test(priority = 8, groups = {"validation form", "negative"})
    @Description("Проверка валидации формы добавления документа")
    public void checkingValidationDocumentAdditionForm() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.fillEmployeeDataRetail();
        preconditions.choosingCitizenship(TypeCitizenship.RF);
        preconditions.SavingDataAfterInput();
        checkNotification.checkSaveNotification();
        preconditions.verifyFirstStageTransition();
        preconditions.openDocumentForm();
        preconditions.clickSaveDocument();
        employeeErrorDataForm.documentTypeError.shouldBe(exist, visible);
        employeeColorIndicatorLocators.colorDocumentType.shouldBe(cssValue(ColorPage.COLOR, ColorPage.ERROR_COLOR));
        employeeErrorDataForm.dropZoneError.shouldBe(exist, visible);
        employeeColorIndicatorLocators.colorDropZone.shouldBe(cssValue(ColorPage.COLOR, ColorPage.ERROR_COLOR));
        checkNotification.checkNotificationText();
        closeForm();
        closeForm();
    }

    @Test(priority = 9, groups = {"validation form", "negative"})
    @Description("Проверка валидации дроп зоны. Загрузка файла недопустимого формата: CSV")
    public void checkingValidationDropZone() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.fillEmployeeDataRetail();
        preconditions.choosingCitizenship(TypeCitizenship.RF);
        preconditions.SavingDataAfterInput();
        checkNotification.checkSaveNotification();
        preconditions.verifyFirstStageTransition();
        preconditions.addDocument(DocumentType.PASSPORT, TestFile.CSV);
    }
}