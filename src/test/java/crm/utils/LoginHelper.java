package crm.utils;

import crm.UserConfig;
import crm.adapters.pages.AuthorizationPage;

public class LoginHelper {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    public void loginAsManagerRetail() {
        loginAsUser("Retail_m_auth", UserConfig.getPassword("Retail_m_auth"));
    }

    public void loginAsDBA() {
        loginAsUser("domnin", UserConfig.getPassword("domnin"));
    }

    public void loginAsManagerLogistic() {
        loginAsUser("Logistics_m_auth", UserConfig.getPassword("Logistics_m_auth"));
    }

    public void loginAsUser(String login, String password) {
        authorizationPage.dataEntry(login, password);
    }

}