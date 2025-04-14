package Ilya_S.pageObjects.chapter_4;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class IFramesPage extends BasePage {
    private static final String IFRAMES_FORM_URL = "iframes.html";
    public static final String IFRAMES_FORM_TITLE = "IFrame";

    public IFramesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get iframes page url")
    public String getUrl() {
        return IFRAMES_FORM_URL;
    }
}
