package crm.utils;

import crm.UserConfig;
import crm.adapters.pages.AuthorizationPage;

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
}