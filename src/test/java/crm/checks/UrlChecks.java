package crm.checks;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class UrlChecks {

    public static class BaseChecks {

        public static void checkPageRedirect() {
            webdriver().shouldHave(urlContaining("/main/new"));
        }
    }

    public static class PersonalCreationChecks {

        public static void checkPagePersonal() {
            webdriver().shouldHave(urlContaining("/personal/main"));
        }

        public static void checkPageAddPersonalForm() {
            webdriver().shouldHave(urlContaining("/personal/main/add"));
        }

        public static void checkingAddDocumentForm() {
            webdriver().shouldHave(urlContaining("/personal/main/add/new_s"));
        }
    }

    public static class AuthorizationChecks {

        public static void checkNoRedirect() {
            webdriver().shouldHave(urlContaining("/login"));
        }
    }
}
