package crm.page.notifification;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NotificationPage {

    public final SelenideElement notification = $x("//ul[@class=\"container-group\"]");


}
