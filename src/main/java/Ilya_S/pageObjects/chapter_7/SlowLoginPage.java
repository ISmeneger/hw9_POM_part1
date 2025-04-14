package Ilya_S.pageObjects.chapter_7;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SlowLoginPage extends BasePage {
    private static final String SLOW_LOGIN_FORM_URL = "login-slow.html";
    public static final String SLOW_LOGIN_FORM_TITLE = "Slow login form";

    public SlowLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get slow login form page url")
    public String getUrl() {
        return SLOW_LOGIN_FORM_URL;
    }
}
