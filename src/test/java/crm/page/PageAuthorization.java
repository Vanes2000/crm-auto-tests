package crm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAuthorization {

    private WebDriver driver;

    private WebDriverWait wait;

    private final By loginField = By.xpath("//*[@id=\"input-14\"]");

    private final By passwordField = By.xpath("//*[@id=\"input-17\"]");

    private final By authorizationBtn = By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div/main/div/div/div/form/button");

    private final By notificationLocator = By.xpath("//*[@id=\"app\"]/div/div[2]/ul/div");

    public PageAuthorization(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void dataEntry(String login, String password){
        driver.findElement(loginField).click();
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(authorizationBtn).click();
    }

    public void correctInput() {
        dataEntry("domnin", "26061992h");
        checkSuccessNotification();
        checkPageRedirect();
    }

    public void incorrectInputLogin() {
        dataEntry("domni", "26061992h");
        checkSuccessNotificationError();
        checkNoRedirect();
    }

    public void incorrectInputPassword() {
        dataEntry("domnin", "26061992");
        checkSuccessNotificationError();
        checkNoRedirect();
    }

    public void incorrectInputNotification() {
        dataEntry("", "");
        checkNoRedirect();
    }

    public void checkSuccessNotification() {
        wait.until(ExpectedConditions.textToBe(notificationLocator, "Вы успешно авторизовались"));
    }

    public void checkPageRedirect() {

        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("/login")));
    }

    public void checkSuccessNotificationError() {
        wait.until(ExpectedConditions.textToBe(notificationLocator, "Не верный логин или пароль"));
    }

    public void checkNoRedirect() {
        wait.until(ExpectedConditions.urlContains("/login"));
    }

}