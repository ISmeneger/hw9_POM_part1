package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_9.ABTestingPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_9.ABTestingPage.AB_TESTING_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ABTestingTests extends BaseTest {

    @Test
    void openABTestingTest() {
        HomePage homePage = new HomePage(driver);
        ABTestingPage abTestingPage = homePage.openABTestingPage();
        String currentUrl = abTestingPage.getCurrentUrl();
        WebElement title = abTestingPage.getTitle();
        String abTestingPageFormUrl = abTestingPage.getUrl();

        assertEquals(BASE_URL + abTestingPageFormUrl, currentUrl);
        assertEquals(AB_TESTING_FORM_TITLE, title.getText());
    }
}
