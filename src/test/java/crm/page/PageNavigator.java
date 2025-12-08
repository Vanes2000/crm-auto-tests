package crm.page;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class PageNavigator {

    public void checkPageRedirect() {webdriver().shouldHave(urlContaining("/main/new"));}

    public void checkPagePersonal() {
        webdriver().shouldHave(urlContaining("/personal/main"));
    }

    public void checkPageAddPersonalForm(){
        webdriver().shouldHave(urlContaining("/personal/main/add"));
    }

    public void checkPageAddPersonalFormDoc(){webdriver().shouldHave(urlContaining("/personal/main/add/new_scan"));}

}
