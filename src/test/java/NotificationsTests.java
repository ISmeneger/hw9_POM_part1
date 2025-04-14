import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_5.NotificationsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_5.NotificationsPage.NOTIFICATIONS_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationsTests extends BaseTest {

    @Test
    void openNotificationsTest() {
        HomePage homePage = new HomePage(driver);
        NotificationsPage notificationsPage= homePage.openNotificationsPage();
        String currentUrl = notificationsPage.getCurrentUrl();
        WebElement title = notificationsPage.getTitle();
        String notificationsPageFormUrl = notificationsPage.getUrl();

        assertEquals(BASE_URL + notificationsPageFormUrl, currentUrl);
        assertEquals(NOTIFICATIONS_FORM_TITLE, title.getText());
    }
}
