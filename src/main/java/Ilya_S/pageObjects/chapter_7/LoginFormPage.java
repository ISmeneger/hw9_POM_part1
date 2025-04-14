package Ilya_S.pageObjects.chapter_7;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {
    private static final String LOGIN_FORM_URL = "login-form.html";
    public static final String LOGIN_FORM_TITLE = "Login form";

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get login form page url")
    public String getUrl() {
        return LOGIN_FORM_URL;
    }
}
