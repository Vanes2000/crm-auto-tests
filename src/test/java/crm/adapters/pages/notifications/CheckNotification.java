package crm.adapters.pages.notifications;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class CheckNotification {

    public void checkSaveNotification() {
        NotificationPage.notification
                .shouldBe(visible, Duration.ofSeconds(5))
                .shouldHave(exactText("Сохранено"))
                .shouldBe(disappear, Duration.ofSeconds(10));
    }

    public void checkSuccessNotification() {
        NotificationPage.notification.shouldHave(text("Вы успешно авторизовались"));
    }

    public void checkErrorSuccessNotification() {
        NotificationPage.notification.shouldHave(text("Не верный логин или пароль"));
    }

    public void checkNotificationText() {
        NotificationPage.notification
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldHave(exactText("Проверьте все поля"))
                .shouldBe(disappear, Duration.ofSeconds(10));
    }
}
