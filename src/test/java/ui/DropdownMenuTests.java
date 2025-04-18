package ui;

import Ilya_S.pageObjects.chapter_3.DropdownMenuPage;
import Ilya_S.pageObjects.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.chapter_3.DropdownMenuPage.DROPDOWN_FORM_TITLE;
import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DropdownMenuTests extends BaseTest {

    @Test
    void openDropdownMenuTest() {
        HomePage homePage = new HomePage(driver);
        DropdownMenuPage dropdownMenuPage = homePage.openDropdownMenuPage();
        String currentUrl = dropdownMenuPage.getCurrentUrl();
        WebElement title = dropdownMenuPage.getTitle();
        String dropdownMenuFormUrl = dropdownMenuPage.getUrl();

        assertEquals(BASE_URL + dropdownMenuFormUrl, currentUrl);
        assertEquals(DROPDOWN_FORM_TITLE, title.getText());
    }
}

