package crm.tests;

import crm.page.PageAuthorization;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class AuthorizationTest extends BasedTest{

    PageAuthorization auth = new PageAuthorization();

    @Test
    @Tag("Authorization")
    @Description("Авторизация с валидными данными")
    public void verifyingAuthorizationWithValidData() {
        auth.dataEntry("domnin", "26061992h");
        checkPageRedirect();
        checkSuccessNotification();
    }

    @Test
    @Tag("Authorization")
    @Description("Авторизация с вводом невалидного логина")
    public void CheckingAuthorizationByEnteringAnInvalidLogin() {
        auth.dataEntry("domni", "26061992h");
        checkSuccessNotificationError();
        checkNoRedirect();
    }

    @Test
    @Tag("Authorization")
    @Description("Авторизация с вводом невалидного пароля")
    public void CheckingAuthorizationByEnteringAnInvalidPassword() {
        auth.dataEntry("domnin", "26061992");
        checkSuccessNotificationError();
        checkNoRedirect();
    }

    @Test
    @Tag("Authorization")
    @Description("Проверка обязательных полей")
    public void checkingRequiredFields(){
        auth.dataEntry("", "");
        checkNoRedirect();
    }

    @Test
    @Tag("Authorization")
    @Description("Проверка наименования элементов формы")
    public void checkingFormElements(){
        auth.nameFormLocator.shouldHave(text("Авторизация"));
        auth.loginInput.shouldHave(text("Логин"));
        auth.passwordInput.shouldHave(text("Пароль"));
        auth.authorizationBtn.shouldHave(text("Войти"));
    }

    public void checkSuccessNotification() {
        auth.notificationLocator.shouldHave(text("Вы успешно авторизовались"));
    }

    public void checkPageRedirect() {
        webdriver().shouldHave(urlContaining("/main/new"));
    }

    public void checkSuccessNotificationError() {
        auth.notificationLocator.shouldHave(text("Не верный логин или пароль"));
    }

    public void checkNoRedirect() {
        webdriver().shouldHave(urlContaining("/login"));
    }

}
