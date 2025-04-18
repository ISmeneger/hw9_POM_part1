package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_9.DataTypesPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_9.DataTypesPage.DATA_TYPES_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataTypesTests extends BaseTest {

    @Test
    void openDataTypesTest() {
        HomePage homePage = new HomePage(driver);
        DataTypesPage dataTypesPage = homePage.openDataTypesPage();
        String currentUrl = dataTypesPage.getCurrentUrl();
        WebElement title = dataTypesPage.getTitle();
        String dataTypesPageFormUrl = dataTypesPage.getUrl();

        assertEquals(BASE_URL + dataTypesPageFormUrl, currentUrl);
        assertEquals(DATA_TYPES_FORM_TITLE, title.getText());
    }
}
