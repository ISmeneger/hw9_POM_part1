import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_3.NavigationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_3.NavigationPage.NAV_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NavigationTests extends BaseTest {

    @Test
    void openNavigationTest() {
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        WebElement title = navigationPage.getTitle();
        String navigationFormUrl = navigationPage.getUrl();

        assertEquals(BASE_URL + navigationFormUrl, currentUrl);
        assertEquals(NAV_FORM_TITLE, title.getText());
    }
}
