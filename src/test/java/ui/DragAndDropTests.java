package ui;

import Ilya_S.pageObjects.chapter_3.DragAndDropPage;
import Ilya_S.pageObjects.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.chapter_3.DragAndDropPage.DRAG_AND_DROP_FORM_TITLE;
import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DragAndDropTests extends BaseTest {

    @Test
    void openDragAndDropTest() {
        HomePage homePage = new HomePage(driver);
        DragAndDropPage dragAndDropPage = homePage.openDragAndDropPage();
        String currentUrl = dragAndDropPage.getCurrentUrl();
        WebElement title = dragAndDropPage.getTitle();
        String dragAndDropPageFormUrl = dragAndDropPage.getUrl();

        assertEquals(BASE_URL + dragAndDropPageFormUrl, currentUrl);
        assertEquals(DRAG_AND_DROP_FORM_TITLE, title.getText());
    }
}
