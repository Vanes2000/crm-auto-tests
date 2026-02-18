package crm.tests;

import com.opencsv.exceptions.CsvException;

import crm.page.PageNavigator;
import crm.page.PersonalPage;
import crm.utils.NameGenerator;
import crm.utils.UserConfig;
import crm.page.notifification.NotificationPage;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exactText;
import static crm.utils.NameGenerator.generateRandomBirthDate;


public class PersonalTestRoznica extends BasedTest{

    PersonalPage.TheFirstStage theFirstStage = new PersonalPage.TheFirstStage();
    PersonalPage.TheSecondStage theSecondStage = new PersonalPage.TheSecondStage();

    NotificationPage notif = new NotificationPage();
    UserConfig userConfig = new UserConfig();
    PageNavigator navigator = new PageNavigator();

    PersonalTestLogistik personalTestLogistik = new PersonalTestLogistik();

    @BeforeMethod
    public void openAuth() throws IOException, CsvException {
        userConfig.loginAsManagerRoznica();
        navigator.checkPageRedirect();
    }


    @Description("Первый этап. Заполнение основных данных сотрудника")
    public void fillBasicStaffDataAndProceed(){
        String[] randomName = NameGenerator.generateRandomName();
        String firstName = randomName[0];
        String lastName = randomName[1];
        String middleName = randomName[2];

        theFirstStage.fieldSurName.shouldBe(exist, visible).click();
        theFirstStage.fieldSurName.setValue(lastName);
        theFirstStage.fieldName.shouldBe(exist, visible).click();
        theFirstStage.fieldName.setValue(firstName);
        theFirstStage.fieldPatronymic.shouldBe(exist, visible).click();
        theFirstStage.fieldPatronymic.setValue(middleName);
        theFirstStage.fieldDateOfBirth.shouldBe(exist, visible).click();
        theFirstStage.fieldDateOfBirth.setValue(generateRandomBirthDate());
        theFirstStage.fieldTelephone.shouldBe(exist, visible).click();
        theFirstStage.fieldTelephone.setValue("88887776655");
        theFirstStage.fieldCitizenship.shouldBe(exist, visible).click();
        theFirstStage.citizenshipOfTheRussianFederation.click();
    }

    @Test
    @Description("Добавление линейщика с обязательным документом")
    public void failedUserAddition() throws InterruptedException {
        personalTestLogistik.openStaffAdditionForm();
        fillBasicStaffDataAndProceed();
        personalTestLogistik.SavingInTheFirstStepAndCheckingTheTransitionToTheSecondStepOfAdding();
        theSecondStage.buttonAdd.shouldBe(exist, visible).click();
        navigator.checkPageAddPersonalFormDoc();
        theSecondStage.divSelectSlot.shouldBe(exist, visible).click();
        theSecondStage.passport.shouldBe(exist, visible).click();
        theSecondStage.divClickable.shouldBe(exist).uploadFromClasspath((theSecondStage.filePath));
        theSecondStage.buttonSaveDoc.shouldBe(exist, visible).click();
        notif.notification.shouldHave(exactText("Сохранено"));
        notif.notification.shouldHave(exactText("Загружено успешно"));
        theSecondStage.spanContent.shouldBe(exist, visible).click();
        //Проверяем переход в таблицу с добавленным персоналом
        navigator.checkPagePersonal();
        notif.notification.shouldHave(exactText("Сохранено"));
    }

    @Test
    @Description("Добавление линейщика с признаком без ДУЛ")
    public void AddingALinemanWithoutRequiredDocuments(){
        personalTestLogistik.openStaffAdditionForm();
        fillBasicStaffDataAndProceed();
        theFirstStage.checkboxWithoutIdentificationDocuments.shouldBe(exist, visible).click();
        personalTestLogistik.SavingInTheFirstStepAndCheckingTheTransitionToTheSecondStepOfAdding();
        theSecondStage.spanContent.click();
        //Проверяем переход в таблицу с добавленным персоналом
        navigator.checkPagePersonal();
        notif.notification.shouldHave(exactText("Сохранено"));
    }

    @Test
    @Description("Проверка валидации при добавлении линейщика без признака без ДУЛ")
    public void ValidationCheckWhenAddingALineWorkerWithoutAnIDOrIdentificationDocuments(){
        personalTestLogistik.openStaffAdditionForm();
        fillBasicStaffDataAndProceed();
        personalTestLogistik.SavingInTheFirstStepAndCheckingTheTransitionToTheSecondStepOfAdding();
        theSecondStage.spanContent.click();
        notif.notification.shouldHave(exactText("Необходимо приложить ID карту или паспорт"));
    }

    @Test
    @Description("Добавление уже существующего линейщика")
    public void AddingAnExistingEmployee(){
        personalTestLogistik.openStaffAdditionForm();
        theFirstStage.fieldSurName.click();
        theFirstStage.fieldSurName.setValue("Орлова");
        theFirstStage.fieldName.click();
        theFirstStage.fieldName.setValue("Варвара");
        theFirstStage.fieldPatronymic.click();
        theFirstStage.fieldPatronymic.setValue("Даниловна");
        theFirstStage.fieldDateOfBirth.click();
        theFirstStage.fieldDateOfBirth.setValue("22.04.1962");
        theFirstStage.fieldTelephone.click();
        theFirstStage.fieldTelephone.setValue("88887776655");
        theFirstStage.fieldCitizenship.click();
        theFirstStage.citizenshipOfTheRussianFederation.click();
        theFirstStage.buttonSave.click();
        theFirstStage.notificationThatAnEmployeeAlreadyExists.shouldBe(exist, visible).shouldHave(exactText("Сотрудник уже есть в системе, перейти"));
    }

    @Test
    @Description("Проверка валидации полей обязательных к заполнению")
    public void ValidationOfRequiredFields(){
        personalTestLogistik.openStaffAdditionForm();
        theFirstStage.buttonSave.click();
        notif.notification.shouldHave(exactText("Проверьте все поля"));
    }

}