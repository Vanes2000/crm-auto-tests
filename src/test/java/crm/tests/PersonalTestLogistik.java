package crm.tests;

import com.opencsv.exceptions.CsvException;
import crm.page.PageNavigator;
import crm.page.PersonalPage;
import crm.page.notifification.NotificationPage;
import crm.utils.NameGenerator;
import crm.utils.UserConfig;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static crm.utils.NameGenerator.generateRandomBirthDate;

public class PersonalTestLogistik extends BasedTest {

    PersonalPage.MainPage main = new PersonalPage.MainPage();
    PersonalPage.TheFirstStage stage = new PersonalPage.TheFirstStage();
    PersonalPage.PersonalModal modal = new PersonalPage.PersonalModal();

    NotificationPage notif = new NotificationPage();
    UserConfig userConfig = new UserConfig();
    PageNavigator navigator = new PageNavigator();


    @BeforeMethod
    public void openAuth() throws IOException, CsvException {
        userConfig.loginAsManagerLogistic();
        navigator.checkPageRedirect();
    }

    @Description("Переход в форму добавления сотрудника после авторизации")
    public void openStaffAdditionForm() {
        main.buttonHeaderHover.shouldBe(exist, visible).click();
        main.linkNoneRouter.shouldBe(exist, visible).click();
        navigator.checkPagePersonal();
        main.buttonOutlinedTheme.shouldBe(exist, visible).click();
        navigator.checkPageAddPersonalForm();
        main.pText.shouldBe(exist, visible).shouldHave(exactText("Персонал"));
    }

    @Description("Сохранение данных на первом этапе и проверка перехода на второй этап добавления сотрудника")
    public void SavingInTheFirstStepAndCheckingTheTransitionToTheSecondStepOfAdding(){
        stage.buttonSave.shouldBe(exist, visible).click();
        navigator.checkPageAddPersonalForm();
        notif.notification.shouldHave(exactText("Сохранено"));
    }

    @Description("Первый этап. Заполнение основных данных сотрудника")
    public void fillBasicStaffDataAndProceed(){
        String[] randomName = NameGenerator.generateRandomName();
        String firstName = randomName[0];
        String lastName = randomName[1];
        String middleName = randomName[2];

        openStaffAdditionForm();
        stage.fieldSurName.shouldBe(exist, visible).click();
        stage.fieldSurName.setValue(lastName);
        stage.fieldName.shouldBe(exist, visible).click();
        stage.fieldName.setValue(firstName);
        stage.fieldPatronymic.shouldBe(exist, visible).click();
        stage.fieldPatronymic.setValue(middleName);
        stage.fieldDateOfBirth.shouldBe(exist, visible).click();
        stage.fieldDateOfBirth.setValue(generateRandomBirthDate());
        stage.objectField.shouldBe(exist, visible).click();
        stage.selectObject.shouldBe(exist, visible).click();
        stage.form.doubleClick();
        stage.AccessFiled.shouldBe(exist, visible).click();
        stage.selectAccess.shouldBe(exist, visible).click();
        stage.form.doubleClick();
        stage.fieldCitizenship.shouldBe(exist, visible).click();
        stage.citizenshipOfTheRussianFederation.shouldBe(exist, visible).click();
    }

    @Test
    @Description("Добавление линейщика с трансфером и обязательным документом")
    public void verificationAddingAnEmployeeWithATransferAndARequiredDocument(){
        fillBasicStaffDataAndProceed();
        modal.transferCheckBox.shouldBe(exist, visible).click();
        modal.addressField_A.shouldBe(exist, visible).click();
        modal.addressField_A.setValue("ул. Рязанова 163");
        modal.transferObjectFiled.shouldBe(exist, visible).click();
        modal.transferSelectObject.shouldBe(exist, visible).click();
        modal.transferSelectRegion.shouldBe(exist, visible).shouldHave(exactText("Волгоградская область"));
        modal.localitySelect.shouldBe(exist, visible).shouldHave(exactText("Волгоград"));
        modal.addressField_B.shouldBe(exist, visible).click();
        modal.addressField_B.setValue("ул. Гагаринская 49");
        SavingInTheFirstStepAndCheckingTheTransitionToTheSecondStepOfAdding();
        //Второй этап
    }

    @Test
    @Description("Добавление линейщика без трансфера, но с обязательным документом")
    public void CheckingTheAdditionOfAnEmployeeWithoutATransferAndARequiredDocument(){
        fillBasicStaffDataAndProceed();
        SavingInTheFirstStepAndCheckingTheTransitionToTheSecondStepOfAdding();
        //Второй этап
    }


}
