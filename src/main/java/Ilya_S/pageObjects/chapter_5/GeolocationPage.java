package Ilya_S.pageObjects.chapter_5;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class GeolocationPage extends BasePage {
    private static final String GEOLOCATION_FORM_URL = "geolocation.html";
    public static final String GEOLOCATION_FORM_TITLE = "Geolocation";

    public GeolocationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get geolocation page url")
    public String getUrl() {
        return GEOLOCATION_FORM_URL;
    }
}
