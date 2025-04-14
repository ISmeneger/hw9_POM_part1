package Ilya_S.pageObjects.chapter_3;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DrawingInCanvasPage extends BasePage {
    private static final String DRAWING_IN_CANVAS_FORM_URL = "draw-in-canvas.html";
    public static final String DRAWING_IN_CANVAS_FORM_TITLE = "Drawing in canvas";

    public DrawingInCanvasPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get drawing in canvas page url")
    public String getUrl() {
        return DRAWING_IN_CANVAS_FORM_URL;
    }
}
