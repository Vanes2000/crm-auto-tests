package crm.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;


public class BasedTest {

    @BeforeMethod
    public void setUp(){
        open("/login");
    }

    @BeforeTest  // ← Выполняется перед КАЖДЫМ тестом
    public void globalSetUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 1000000000;
        Configuration.pageLoadTimeout = 2000000;
        Configuration.baseUrl = "https://test.personal-crm.ru";
    }

//    "http://10.163.20.139:3033";

    @AfterMethod   //Выполняется после КАЖДОГО теста
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
