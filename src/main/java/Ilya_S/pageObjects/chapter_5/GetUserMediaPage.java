package Ilya_S.pageObjects.chapter_5;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class GetUserMediaPage extends BasePage {
    private static final String GET_USER_MEDIA_FORM_URL = "get-user-media.html";
    public static final String GET_USER_MEDIA_FORM_TITLE = "Get user media";

    public GetUserMediaPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get get user media page url")
    public String getUrl() {
        return GET_USER_MEDIA_FORM_URL;
    }
}
