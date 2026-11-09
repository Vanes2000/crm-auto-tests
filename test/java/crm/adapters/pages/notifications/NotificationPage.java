package crm.adapters.pages.notifications;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NotificationPage {

    public static final SelenideElement notification = $x("//ul[@class=\"container-group\"]");

}