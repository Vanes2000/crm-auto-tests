package crm.utils;

import com.opencsv.exceptions.CsvException;
import crm.page.AuthorizationPage;

import java.io.IOException;

public class UserConfig {

    private static final DataTests dataTests = new DataTests();

    public static String getManagerRoznicaLogin() {
        return "lipatov";
    }

    public static String getManagerPassword() throws IOException, CsvException {
        return dataTests.readUsersFromFile().get("lipatov");
    }

    public static String getDBALogin() {
        return "domnin";
    }

    public static String getDBAPassword() throws IOException, CsvException {
        return dataTests.readUsersFromFile().get("domnin");
    }

    public static String getManagerLogisticLogin() {
        return "ruzhickiy";
    }

    public static String getManagerLogisticPassword() throws IOException, CsvException {
        return dataTests.readUsersFromFile().get("ruzhickiy");
    }

    AuthorizationPage authPage = new AuthorizationPage();


    public void loginAsManagerRoznica() throws IOException, CsvException {
        loginAsUser(UserConfig.getManagerRoznicaLogin(), UserConfig.getManagerPassword());
    }

    public void loginAsDBA() throws IOException, CsvException {
        loginAsUser(UserConfig.getDBALogin(), UserConfig.getDBAPassword());
    }

    public void loginAsManagerLogistic() throws IOException, CsvException {
        loginAsUser(UserConfig.getManagerLogisticLogin(), UserConfig.getManagerLogisticPassword());
    }

    //Общий метод ввода данных для авторизации
    public void loginAsUser(String username, String password) {
        authPage.dataEntry(username, password);
    }
}