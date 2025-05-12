package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_4.IFramesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_4.IFramesPage.IFRAMES_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IFrameTests extends BaseTest {

    @Test
    @DisplayName("Check IFrames page")
    void openIFramesTest() {
        HomePage homePage = new HomePage(driver);
        IFramesPage iframesPage = homePage.openIFramesPage();
        String currentUrl = iframesPage.getCurrentUrl();
        WebElement title = iframesPage.getTitle();
        String iframesPageFormUrl = iframesPage.getUrl();

        assertEquals(BASE_URL + iframesPageFormUrl, currentUrl);
        assertEquals(IFRAMES_FORM_TITLE, title.getText());
    }
}
