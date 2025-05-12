package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_7.SlowLoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_7.SlowLoginPage.SLOW_LOGIN_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SlowLoginTests extends BaseTest {

    @Test
    @DisplayName("Check Slow login page")
    void openSlowLoginTest() {
        HomePage homePage = new HomePage(driver);
        SlowLoginPage slowLoginPage = homePage.openSlowLoginPage();
        String currentUrl = slowLoginPage.getCurrentUrl();
        WebElement title = slowLoginPage.getTitle();
        String slowLoginPageFormUrl = slowLoginPage.getUrl();

        assertEquals(BASE_URL + slowLoginPageFormUrl, currentUrl);
        assertEquals(SLOW_LOGIN_FORM_TITLE, title.getText());
    }
}
