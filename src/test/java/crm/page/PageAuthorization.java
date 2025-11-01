package crm.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PageAuthorization {

    public final SelenideElement loginField = $x("//input[@name=\"login\"]");

    public final SelenideElement loginInput = $x("//label[@for=\"input-14\"]");

    public final SelenideElement passwordField = $x("//input[@name=\"password\"]");

    public final SelenideElement passwordInput = $x("//label[@for=\"input-17\"]");

    public final SelenideElement authorizationBtn = $x("//span[@class=\"v-btn__content\"]");

    public final SelenideElement notificationLocator = $x("//ul[@class=\"container-group\"]");

    public final SelenideElement nameFormLocator = $x("//div[@class=\"v-card__title text-h5 login-header\"]");


    public void dataEntry(String login, String password){
        loginField.click();
        loginField.setValue(login);
        passwordField.click();
        passwordField.setValue(password);
        authorizationBtn.click();
    }
}
