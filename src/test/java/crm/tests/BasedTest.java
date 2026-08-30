package crm.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import crm.adapters.pages.PersonalPage;
import crm.adapters.pages.notifications.CheckNotification;
import crm.tests.precondition.PreconditionTestPersonal;
import crm.utils.LoginHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public class BasedTest {

    CheckNotification checkNotification = new CheckNotification();
    PreconditionTestPersonal preconditions = new PreconditionTestPersonal();
    LoginHelper loginHelper = new LoginHelper();
    PersonalPage.EmployeeErrorDataForm employeeErrorDataForm = new PersonalPage.EmployeeErrorDataForm();
    PersonalPage.EmployeeColorIndicatorLocators employeeColorIndicatorLocators = new PersonalPage.EmployeeColorIndicatorLocators();
    PersonalPage.EmployeeDataForm employeeDataForm = new PersonalPage.EmployeeDataForm();
    PersonalPage.EmployeeDocumentsForm employeeDocumentsForm = new PersonalPage.EmployeeDocumentsForm();

    public void closeForm() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public static String URL_BASE = "https://crm-4.stand.personal-crm.ru";

    @BeforeClass
    public void setUp() {
        open("/login");
    }

    @BeforeTest
    public void globalSetUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 2000000;
        Configuration.baseUrl = URL_BASE;
    }

    @AfterSuite
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}