package Ilya_S.pageObjects.chapter_3;

import Ilya_S.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SlowCalculatorPage extends BasePage {
    private static final String SLOW_CALCULATOR_FORM_URL = "slow-calculator.html";
    public static final String SLOW_CALCULATOR_FORM_TITLE = "Slow calculator";


    public SlowCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get slow calculator page url")
    public String getUrl() {
        return SLOW_CALCULATOR_FORM_URL;
    }
}
