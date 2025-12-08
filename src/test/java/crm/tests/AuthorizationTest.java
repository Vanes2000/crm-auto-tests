package crm.tests;

import com.opencsv.exceptions.CsvException;
import crm.page.AuthorizationPage;
import crm.utils.UserConfig;
import crm.page.notifification.NotificationPage;
import io.qameta.allure.Description;

import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class AuthorizationTest extends BasedTest{

    AuthorizationPage auth = new AuthorizationPage();
    NotificationPage notif = new NotificationPage();
    UserConfig userConfig = new UserConfig();

    public void openingAuthorizationPage(){
        open("/login");
    }

    @Test(priority = 1, groups = "AuthorizationTest")
    @Description("Проверка наименования элементов формы")
    public void checkingFormElements(){
        openingAuthorizationPage();
        auth.divLoginHeader.shouldHave(exactText("Авторизация"));
        auth.inputLogin.shouldHave(exactText("Логин"));
        auth.inputPassword.shouldHave(exactText("Пароль"));
        auth.spanContent.shouldHave(exactText("Войти"));
    }

    @Test(priority = 2, groups = "AuthorizationTest")
    @Description("Авторизация с валидными данными")
    public void verifyingAuthorizationWithValidData() throws IOException, CsvException {
        openingAuthorizationPage();
        userConfig.loginAsDBA();
        checkPageRedirect();
        checkSuccessNotification();
    }

    @Test(priority = 3, groups = "AuthorizationTest")
    @Description("Авторизация с вводом невалидного логина")
    public void CheckingAuthorizationByEnteringAnInvalidLogin() {
        openingAuthorizationPage();
        auth.dataEntry("domni", "26061992h");
        checkSuccessNotificationError();
        checkNoRedirect();
    }

    @Test(priority = 4, groups = "AuthorizationTest")
    @Description("Авторизация с вводом невалидного пароля")
    public void CheckingAuthorizationByEnteringAnInvalidPassword() {
        openingAuthorizationPage();
        auth.dataEntry("domnin", "26061992");
        checkSuccessNotificationError();
        checkNoRedirect();
    }

    @Test(priority = 5, groups = "AuthorizationTest")
    @Description("Проверка обязательных полей")
    public void checkingRequiredFields(){
        openingAuthorizationPage();
        auth.dataEntry("", "");
        checkNoRedirect();
    }

    @Test(priority = 6, groups = "AuthorizationTest")
    @Description("Проверка валидации пароля")
    public void passwordValidationCheck(){
        openingAuthorizationPage();
        auth.dataEntry("domnin", "");
        checkNoRedirect();
    }

    @Test(priority = 7, groups = "AuthorizationTest")
    @Description("Проверка валидации логина")
    public void loginValidationCheck(){
        openingAuthorizationPage();
        auth.dataEntry("", "26061992h");
        checkNoRedirect();
    }

    public void checkSuccessNotification() {
        notif.notification.shouldHave(text("Вы успешно авторизовались"));
    }

    public void checkPageRedirect() {
        webdriver().shouldHave(urlContaining("/main/new"));
    }

    public void checkSuccessNotificationError() {notif.notification.shouldHave(text("Не верный логин или пароль"));}

    public void checkNoRedirect() {
        webdriver().shouldHave(urlContaining("/login"));
    }

}
