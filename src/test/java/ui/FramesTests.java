package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_4.FramesPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_4.FramesPage.FRAMES_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FramesTests extends BaseTest {

    @Test
    void openFramesTest() {
        HomePage homePage = new HomePage(driver);
        FramesPage framesPage = homePage.openFramesPage();
        framesPage.switchToFrame();
        String currentUrl = framesPage.getCurrentUrl();
        WebElement title = framesPage.getTitle();
        String framesPageFormUrl = framesPage.getUrl();

        assertEquals(BASE_URL + framesPageFormUrl, currentUrl);
        assertEquals(FRAMES_FORM_TITLE, title.getText());
    }
}
