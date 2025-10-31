package crm.tests;

import crm.page.PageAuthorization;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.testng.annotations.Test;

public class AuthorizationTests extends BasedTest {

    @Test
    @Tag("Authorization")
    @Description("Авторизация с вводом невалидного логина")
    public void loginValidation() {
        PageAuthorization auth = new PageAuthorization(driver, wait);
        auth.incorrectInputLogin();
    }

    @Test
    @Tag("Authorization")
    @Description("Авторизация с вводом невалидного пароля")
    public void passwordValidation() {
        PageAuthorization auth = new PageAuthorization(driver, wait);
        auth.incorrectInputPassword();
    }

    @Test
    @Tag("Authorization")
    @Description("Успешная авторизации пользователя")
    public void successfulAuthorization() {
        PageAuthorization auth = new PageAuthorization(driver, wait);
        auth.correctInput();
    }

    @Test
    @Tag("Authorization")
    @Description("Проверка успешной авторизации пользователя")
    public void validationOfRequiredFields(){
        PageAuthorization auth = new PageAuthorization(driver, wait);
        auth.incorrectInputNotification();
    }

}