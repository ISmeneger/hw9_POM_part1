package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_3.SlowCalculatorPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_3.SlowCalculatorPage.SLOW_CALCULATOR_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SlowCalculatorTests extends BaseTest {

    @Test
    @DisplayName("Check Slow calculator page")
    void openSlowCalculatorTest() {
        HomePage homePage = new HomePage(driver);
        SlowCalculatorPage slowCalculatorPage = homePage.openSlowCalculatorPage();
        String currentUrl = slowCalculatorPage.getCurrentUrl();
        WebElement title = slowCalculatorPage.getTitle();
        String slowCalculatorPageFormUrl = slowCalculatorPage.getUrl();

        assertEquals(BASE_URL + slowCalculatorPageFormUrl, currentUrl);
        assertEquals(SLOW_CALCULATOR_FORM_TITLE, title.getText());
    }
}
