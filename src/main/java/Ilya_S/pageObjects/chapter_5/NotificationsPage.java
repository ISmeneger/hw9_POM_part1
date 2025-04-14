package Ilya_S.pageObjects.chapter_5;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class NotificationsPage extends BasePage {
    private static final String NOTIFICATIONS_FORM_URL = "notifications.html";
    public static final String NOTIFICATIONS_FORM_TITLE = "Notifications";

    public NotificationsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get notifications page url")
    public String getUrl() {
        return NOTIFICATIONS_FORM_URL;
    }
}
