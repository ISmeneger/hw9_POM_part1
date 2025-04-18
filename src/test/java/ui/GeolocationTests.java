package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_5.GeolocationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_5.GeolocationPage.GEOLOCATION_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GeolocationTests extends BaseTest {

    @Test
    void openGeolocationTest() {
        HomePage homePage = new HomePage(driver);
        GeolocationPage geolocationPage = homePage.openGeolocationPage();
        String currentUrl = geolocationPage.getCurrentUrl();
        WebElement title = geolocationPage.getTitle();
        String geolocationPageFormUrl = geolocationPage.getUrl();

        assertEquals(BASE_URL + geolocationPageFormUrl, currentUrl);
        assertEquals(GEOLOCATION_FORM_TITLE, title.getText());
    }
}
