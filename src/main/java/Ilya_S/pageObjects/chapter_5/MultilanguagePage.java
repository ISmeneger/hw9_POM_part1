package Ilya_S.pageObjects.chapter_5;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MultilanguagePage extends BasePage {
    private static final String MULTILANGUAGE_FORM_URL = "multilanguage.html";
    public static final String MULTILANGUAGE_FORM_TITLE = "";

    public MultilanguagePage(WebDriver driver) {
        super(driver);
    }

    @Step("Get Multilanguage page url")
    public String getUrl() {
        return MULTILANGUAGE_FORM_URL;
    }
}
