package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_8.RandomCalculatorPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_8.RandomCalculatorPage.RANDOM_CALCULATOR_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomCalculatorTests extends BaseTest {

    @Test
    @DisplayName("Check Random calculator page")
    void openRandomCalculatorTest() {
        HomePage homePage = new HomePage(driver);
        RandomCalculatorPage randomCalculatorPage = homePage.openRandomCalculatorPage();
        String currentUrl = randomCalculatorPage.getCurrentUrl();
        WebElement title = randomCalculatorPage.getTitle();
        String randomCalculatorPageFormUrl = randomCalculatorPage.getUrl();

        assertEquals(BASE_URL + randomCalculatorPageFormUrl, currentUrl);
        assertEquals(RANDOM_CALCULATOR_FORM_TITLE, title.getText());
    }
}
