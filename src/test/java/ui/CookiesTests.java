package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_4.CookiesPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_4.CookiesPage.COOKIES_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CookiesTests extends BaseTest {

    @Test
    void openCookiesTest() {
        HomePage homePage = new HomePage(driver);
        CookiesPage cookiesPage= homePage.openCookiesPage();
        String currentUrl = cookiesPage.getCurrentUrl();
        WebElement title = cookiesPage.getTitle();
        String cookiesPageFormUrl = cookiesPage.getUrl();

        assertEquals(BASE_URL + cookiesPageFormUrl, currentUrl);
        assertEquals(COOKIES_FORM_TITLE, title.getText());
    }
}
