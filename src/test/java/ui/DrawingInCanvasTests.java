package ui;

import Ilya_S.pageObjects.chapter_3.DrawingInCanvasPage;
import Ilya_S.pageObjects.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.chapter_3.DrawingInCanvasPage.DRAWING_IN_CANVAS_FORM_TITLE;
import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DrawingInCanvasTests extends BaseTest {

    @Test
    void openDrawingInCanvasTest() {
        HomePage homePage = new HomePage(driver);
        DrawingInCanvasPage drawingInCanvasPage = homePage.openDrawingInCanvasPage();
        String currentUrl = drawingInCanvasPage.getCurrentUrl();
        WebElement title = drawingInCanvasPage.getTitle();
        String drawingInCanvasPageFormUrl = drawingInCanvasPage.getUrl();

        assertEquals(BASE_URL + drawingInCanvasPageFormUrl, currentUrl);
        assertEquals(DRAWING_IN_CANVAS_FORM_TITLE, title.getText());
    }
}
