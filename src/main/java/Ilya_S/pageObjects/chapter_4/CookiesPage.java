package Ilya_S.pageObjects.chapter_4;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CookiesPage extends BasePage {
    private static final String COOKIES_FORM_URL = "cookies.html";
    public static final String COOKIES_FORM_TITLE = "Cookies";

    public CookiesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get cookies page url")
    public String getUrl() {
        return COOKIES_FORM_URL;
    }
}
