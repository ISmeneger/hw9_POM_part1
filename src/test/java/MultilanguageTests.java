import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_5.MultilanguagePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_5.MultilanguagePage.MULTILANGUAGE_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultilanguageTests extends BaseTest {

    @Test
    void openMultilanguageTest() {
        HomePage homePage = new HomePage(driver);
        MultilanguagePage multilanguagePage = homePage.openMultilanguagePage();
        String currentUrl = multilanguagePage.getCurrentUrl();
        WebElement title = multilanguagePage.getTitle();
        String multilanguagePageFormUrl = multilanguagePage.getUrl();

        assertEquals(BASE_URL + multilanguagePageFormUrl, currentUrl);
        assertEquals(MULTILANGUAGE_FORM_TITLE, title.getText());
    }
}
