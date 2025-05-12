package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_3.MouseOverPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_3.MouseOverPage.MOUSE_OVER_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MouseOverTests extends BaseTest {

    @Test
    @DisplayName("Check Mouse over page")
    void openMouseOverTest() {
        HomePage homePage = new HomePage(driver);
        MouseOverPage mouseOverPage = homePage.openMouseOverPage();
        String currentUrl = mouseOverPage.getCurrentUrl();
        WebElement title = mouseOverPage.getTitle();
        String mouseOverPageFormUrl = mouseOverPage.getUrl();

        assertEquals(BASE_URL + mouseOverPageFormUrl, currentUrl);
        assertEquals(MOUSE_OVER_FORM_TITLE, title.getText());
    }
}
