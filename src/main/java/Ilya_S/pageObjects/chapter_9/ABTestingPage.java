package Ilya_S.pageObjects.chapter_9;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ABTestingPage extends BasePage {
    private static final String AB_TESTING_FORM_URL = "ab-testing.html";
    public static final String AB_TESTING_FORM_TITLE = "A/B Testing";


    public ABTestingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get AB testing page url")
    public String getUrl() {
        return AB_TESTING_FORM_URL;
    }
}
