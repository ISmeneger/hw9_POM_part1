package Ilya_S.pageObjects.chapter_9;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DownloadFilesPage extends BasePage {
    private static final String DOWNLOAD_FILES_FORM_URL = "download.html";
    public static final String DOWNLOAD_FILES_FORM_TITLE = "Download files";

    public DownloadFilesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get download files page url")
    public String getUrl() {
        return DOWNLOAD_FILES_FORM_URL;
    }
}
