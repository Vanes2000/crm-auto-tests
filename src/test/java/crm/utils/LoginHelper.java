package crm.utils;

import crm.UserConfig;
import crm.adapters.pages.AuthorizationPage;
import crm.api.TokenProvider;

import java.util.HashMap;
import java.util.Map;

public class LoginHelper {

    public static class Ui {

        AuthorizationPage authorizationPage = new AuthorizationPage ( );

        public void loginAsManagerRetail ( ) {
            loginAsUserUi ( "Retail_m_auth" , UserConfig.getPassword ( "Retail_m_auth" ) );
        }

        public void loginAsManagerRetail1 ( ) {
            loginAsUserUi ( "M_v1_1.1" , UserConfig.getPassword ( "M_v1_1.1" ) );
        }

        public void loginAsDBA ( ) {
            loginAsUserUi ( "domnin" , UserConfig.getPassword ( "domnin" ) );
        }

        public void loginAsManagerLogistic ( ) {
            loginAsUserUi ( "Logistics_m_auth" , UserConfig.getPassword ( "Logistics_m_auth" ) );
        }

        //Общий метод авторизации UI
        public void loginAsUserUi ( String login , String password ) {
            authorizationPage.dataEntry ( login , password );
        }

    }

    public static class Api {

        TokenProvider tokenProvider = new TokenProvider ( );

        private final Map<String, String> tokenCache = new HashMap<>();

        public String asManagerRetail() {
            return asUser("Retail_m_auth", UserConfig.getPassword("Retail_m_auth"));
        }

        public String asManagerRetail1() {
            return asUser("M_v1_1.1", UserConfig.getPassword("M_v1_1.1"));
        }

        public String asDBA() {
            return asUser("domnin", UserConfig.getPassword("domnin"));
        }

        public String asManagerLogistic() {
            return asUser("Logistics_m_auth", UserConfig.getPassword("Logistics_m_auth"));
        }

        //Общий метод авторизации API
        public String asUser(String login, String password) {
            return tokenCache.computeIfAbsent(login, l -> tokenProvider.login(l, password));
        }

        public void invalidate() {
            tokenCache.clear();
        }
    }
}