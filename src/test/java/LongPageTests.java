import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_4.LongPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_4.LongPage.LONG_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongPageTests extends BaseTest {

    @Test
    void openLongPageTest() {
        HomePage homePage = new HomePage(driver);
        LongPage longPage = homePage.openLongPage();
        String currentUrl = longPage.getCurrentUrl();
        WebElement title = longPage.getTitle();
        String longPageFormUrl = longPage.getUrl();

        assertEquals(BASE_URL + longPageFormUrl, currentUrl);
        assertEquals(LONG_FORM_TITLE, title.getText());
    }
}
