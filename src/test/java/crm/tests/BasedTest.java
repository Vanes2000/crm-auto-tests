package crm.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public class BasedTest {


    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x720";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 20000;

        open("https://test.personal-crm.ru/login");
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
