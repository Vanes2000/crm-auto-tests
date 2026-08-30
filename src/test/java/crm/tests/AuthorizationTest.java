package crm.tests;

import crm.adapters.pages.AuthorizationPage;
import crm.checks.UrlChecks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest extends BasedTest {

    AuthorizationPage auth = new AuthorizationPage();

    public void openingAuthorizationPage() {
        open("/login");
    }

    @Test(priority = 1, groups = "AuthorizationTest")
    @Description("Проверка наименования элементов формы")
    public void checkingFormElements() {
        openingAuthorizationPage();
        auth.divLoginHeader.shouldHave(exactText("Авторизация"));
        auth.inputLogin.shouldHave(exactText("Логин"));
        auth.inputPassword.shouldHave(exactText("Пароль"));
        auth.spanContent.shouldHave(exactText("Войти"));
    }

    @Test(priority = 2, groups = "AuthorizationTest")
    @Description("Авторизация с валидными данными")
    public void verifyingAuthorizationWithValidData() {
        openingAuthorizationPage();
        loginHelper.loginAsDBA();
        UrlChecks.BaseChecks.checkPageRedirect();
        checkNotification.checkSuccessNotification();
    }

    @Test(priority = 3, groups = "AuthorizationTest")
    @Description("Авторизация с вводом невалидного логина")
    public void checkingAuthorizationByEnteringAnInvalidLogin() {
        openingAuthorizationPage();
        auth.dataEntry("domni", "26061992h");
        checkNotification.checkErrorSuccessNotification();
        UrlChecks.AuthorizationChecks.checkNoRedirect();
    }

    @Test(priority = 4, groups = "AuthorizationTest")
    @Description("Авторизация с вводом невалидного пароля")
    public void checkingAuthorizationByEnteringAnInvalidPassword() {
        openingAuthorizationPage();
        auth.dataEntry("domnin", "26061992");
        checkNotification.checkErrorSuccessNotification();
        UrlChecks.AuthorizationChecks.checkNoRedirect();
    }

    @Test(priority = 5, groups = "AuthorizationTest")
    @Description("Проверка обязательных полей")
    public void checkingRequiredFields() {
        openingAuthorizationPage();
        auth.dataEntry("", "");
        UrlChecks.AuthorizationChecks.checkNoRedirect();
    }

    @Test(priority = 6, groups = "AuthorizationTest")
    @Description("Проверка валидации пароля")
    public void passwordValidationCheck() {
        openingAuthorizationPage();
        auth.dataEntry("domnin", "");
        UrlChecks.AuthorizationChecks.checkNoRedirect();
    }

    @Test(priority = 7, groups = "AuthorizationTest")
    @Description("Проверка валидации логина")
    public void loginValidationCheck() {
        openingAuthorizationPage();
        auth.dataEntry("", "26061992h");
        UrlChecks.AuthorizationChecks.checkNoRedirect();
    }
}
