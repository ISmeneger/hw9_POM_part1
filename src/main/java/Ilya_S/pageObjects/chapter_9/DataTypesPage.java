package Ilya_S.pageObjects.chapter_9;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DataTypesPage extends BasePage {
    private static final String DATA_TYPES_FORM_URL = "data-types.html";
    public static final String DATA_TYPES_FORM_TITLE = "Data types";


    public DataTypesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get Data Types page url")
    public String getUrl() {
        return DATA_TYPES_FORM_URL;
    }
}
