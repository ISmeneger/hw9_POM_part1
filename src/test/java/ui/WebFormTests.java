package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_3.FormSubmittedPage;
import Ilya_S.pageObjects.chapter_3.WebFormPage;
import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_3.FormSubmittedPage.SUBMITTED_FORM_TEXT;
import static Ilya_S.pageObjects.chapter_3.FormSubmittedPage.SUBMITTED_FORM_TITLE;
import static Ilya_S.pageObjects.chapter_3.WebFormPage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class WebFormTests extends BaseTest {

    HomePage homePage;
    WebFormPage webFormPage;
    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    private static final String USER_FIELD = "user";

    @BeforeEach
    void setupPage() {
        homePage = new HomePage(driver);
        webFormPage = homePage.openWebFormPage();
    }


    @Test
    void openWebFormTest() {
        String currentUrl = webFormPage.getCurrentUrl();
        WebElement title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals(WEB_FORM_TITLE, title.getText());
    }

    @Test
    void openWebFormTestWithCheck() {
        webFormPage.checkIsWebPage();
    }

    @Test
    void textInputTest() {
        webFormPage.inputValue("user");

        assertEquals(USER_FIELD, webFormPage.getTextValue());
    }

    @Test
    void textInputClearTest() {
        webFormPage.inputValue("user");
        webFormPage.clearTextValue();

        String actualText = webFormPage.getTextValue();
        assertThat(actualText).isEmpty();
    }

    @Test
    void passwordInputTest() {
        webFormPage.inputPassword(config.getPassword());

        String actualPassword = webFormPage.getTextPassword();
        assertThat(actualPassword).isNotEmpty();
    }

    @Test
    void passwordClearTest() {
        webFormPage.inputPassword(config.getPassword());
        webFormPage.clearPasswordValue();

        String actualPassword = webFormPage.getTextPassword();
        assertThat(actualPassword).isEmpty();
    }

    @Test
    void textAreaFieldTest() {
        webFormPage.inputTextareaValue(BIG_TEXT);

        assertEquals(BIG_TEXT, webFormPage.getTextarea());
    }

    @Test
    void textAreaFieldClearTest() {
        webFormPage.inputTextareaValue(BIG_TEXT);
        webFormPage.clearTextareaValue();

        String bigText = webFormPage.getTextarea();
        assertThat(bigText).isEmpty();
    }

    @Test
    void disabledInputFieldTest() {
        assertFalse(webFormPage.disabledInput().isEnabled());

        assertThrows(ElementNotInteractableException.class, () -> webFormPage.disabledInput().sendKeys("test string"));

        assertEquals(DISABLED_INPUT_FIELD, webFormPage.getDisabledInputValue());
    }

    @Test
    void readonlyInputFieldTest() {
        assertTrue(webFormPage.readonlyInput().isEnabled());

        assertNotEquals("test string", webFormPage.readonlyInput().findElement(By.xpath("..")).getText());

        assertEquals(READONLY_INPUT_FIELD, webFormPage.getReadonlyInputField());
    }

    @ParameterizedTest
    @ValueSource(strings = {"One", "Two", "Three"})
    public void dropdownSelectByVisibleTextTest(String option) {
        webFormPage.dropdownSelectorByVisibleText(option);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void dropdownSelectByValueTest(String value) {
        webFormPage.dropdownSelectorByValue(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"San Francisco", "New York", "Seattle", "Los Angeles", "Chicago"})
    void dropdownDataListTest(String city) {
        webFormPage.dropDownDataListMenu(city);

        assertEquals(city, webFormPage.getDropdownDataList().getDomProperty(VALUE_NAME));
    }

    @Test
    void fileInputTest() {
        webFormPage.downloadFile();
        webFormPage.submitForm();

        assertThat(driver.getCurrentUrl()).contains("STE+In+Banner");
    }

    @Test
    void checkedCheckboxTest() {
        assertTrue(webFormPage.getCheckedCheckbox().isSelected());

        webFormPage.clickCheckedCheckbox();

        assertFalse(webFormPage.getCheckedCheckbox().isSelected());
    }

    @Test
    void defaultCheckboxTest() {
        assertFalse(webFormPage.getDefaultCheckbox().isSelected());

        webFormPage.clickDefaultCheckbox();

        assertTrue(webFormPage.getDefaultCheckbox().isSelected());
    }

    @Test
    void radioButtonsTest() {
        assertTrue(webFormPage.getCheckedRadio().isSelected());
        assertFalse(webFormPage.getDefaultRadio().isSelected());

        webFormPage.clickDefaultRadio();

        assertFalse(webFormPage.getCheckedRadio().isSelected());
        assertTrue(webFormPage.getDefaultRadio().isSelected());
    }

    @Test
    void colorPickerTest() {
        String initColor = webFormPage.getColor();
        webFormPage.chooseColorPicker();
        String afterColor = webFormPage.getColor();

        assertThat(initColor).isNotEqualTo(afterColor);
        assertThat(Color.fromString(afterColor)).isEqualTo(GREEN);
    }

    @Test
    void datePickerTest() {
        webFormPage.chooseDatePicker("04/14/2025");

        assertEquals("04/14/2025", webFormPage.getDatePicker().getDomProperty(VALUE_NAME));
    }

    @Test
    void actionAPIMouseExampleRangeTest() {
        webFormPage.moveSliderRight();

        assertEquals(String.valueOf(10), webFormPage.getRangeElement().getDomProperty(VALUE_NAME));
    }

    @Test
    void submitFormTest() {
        webFormPage.submitForm();

        FormSubmittedPage formSubmittedPage = new FormSubmittedPage(driver);
        String currentUrl = formSubmittedPage.getCurrentUrl();
        WebElement title = webFormPage.getTitle();
        WebElement submittedText = formSubmittedPage.getSubmittedText();
        String submittedFormUrl = formSubmittedPage.getSubmittedFormUrl();

        assertEquals(submittedFormUrl, currentUrl);
        assertEquals(SUBMITTED_FORM_TITLE, title.getText());
        assertEquals(SUBMITTED_FORM_TEXT, submittedText.getText());
    }
}
