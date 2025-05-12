package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_4.ShadowDOMPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_4.ShadowDOMPage.SHADOW_DOM_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShadowDOMTests extends BaseTest {

    @Test
    @DisplayName("Check Shadow DOM page")
    void openShadowDOMTest() {
        HomePage homePage = new HomePage(driver);
        ShadowDOMPage shadowDOMPage= homePage.openShadowDOMPage();
        String currentUrl = shadowDOMPage.getCurrentUrl();
        WebElement title = shadowDOMPage.getTitle();
        String shadowDOMPageFormUrl = shadowDOMPage.getUrl();

        assertEquals(BASE_URL + shadowDOMPageFormUrl, currentUrl);
        assertEquals(SHADOW_DOM_FORM_TITLE, title.getText());
    }
}
