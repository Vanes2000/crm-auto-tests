package crm.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {

    public SelenideElement inputLogin = $x("//div[contains(@class, 'col-12')][.//*[@id='input-14']]");

    public SelenideElement inputPassword = $x("//div[contains(@class, 'col-12')][.//*[@id='input-17']]");

    public SelenideElement divLoginHeader = $x("//div[contains(@class, 'text-h5')]");

    public SelenideElement spanContent = $x("//span[@class='v-btn__content']");

    public void dataEntry(String login, String password){
        inputLogin.click();
        inputLogin.$("#input-14").setValue(login);
        inputPassword.click();
        inputPassword.$("#input-17").setValue(password);
        spanContent.click();
    }
}
