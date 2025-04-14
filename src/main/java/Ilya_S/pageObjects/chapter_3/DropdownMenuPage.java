package Ilya_S.pageObjects.chapter_3;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DropdownMenuPage extends BasePage {
    private static final String DROPDOWN_FORM_URL = "dropdown-menu.html";
    public static final String DROPDOWN_FORM_TITLE = "Dropdown menu";

    public DropdownMenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get DropdownMenuPage url")
    public String getUrl() {
        return DROPDOWN_FORM_URL;
    }
}
