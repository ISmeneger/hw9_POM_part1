package Ilya_S.pageObjects.chapter_4;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DialogBoxesPage extends BasePage {
    private static final String DIALOG_BOXES_FORM_URL = "dialog-boxes.html";
    public static final String DIALOG_BOXES_FORM_TITLE = "Dialog boxes";

    public DialogBoxesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get dialog boxes page url")
    public String getUrl() {
        return DIALOG_BOXES_FORM_URL;
    }
}
