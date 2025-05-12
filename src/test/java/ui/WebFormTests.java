package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_3.FormSubmittedPage;
import Ilya_S.pageObjects.chapter_3.WebFormPage;
import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Check WebForm page")
    void openWebFormTest() {
        String currentUrl = webFormPage.getCurrentUrl();
        WebElement title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals(WEB_FORM_TITLE, title.getText());
    }

    @Test
    @DisplayName("Check WebForm page")
    void openWebFormTestWithCheck() {
        webFormPage.checkIsWebPage();
    }

    @Test
    @DisplayName("Check user field")
    void textInputTest() {
        webFormPage.inputValue("user");

        assertEquals(USER_FIELD, webFormPage.getTextValue());
    }

    @Test
    @DisplayName("Check clear user field")
    void textInputClearTest() {
        webFormPage.inputValue("user");
        webFormPage.clearTextValue();

        String actualText = webFormPage.getTextValue();
        assertThat(actualText).isEmpty();
    }

    @Test
    @DisplayName("Check password field")
    void passwordInputTest() {
        webFormPage.inputPassword(config.getPassword());

        String actualPassword = webFormPage.getTextPassword();
        assertThat(actualPassword).isNotEmpty();
    }

    @Test
    @DisplayName("Check clear password field")
    void passwordClearTest() {
        webFormPage.inputPassword(config.getPassword());
        webFormPage.clearPasswordValue();

        String actualPassword = webFormPage.getTextPassword();
        assertThat(actualPassword).isEmpty();
    }

    @Test
    @DisplayName("Check textarea field")
    void textAreaFieldTest() {
        webFormPage.inputTextareaValue(BIG_TEXT);

        assertEquals(BIG_TEXT, webFormPage.getTextarea());
    }

    @Test
    @DisplayName("Check clear textarea field")
    void textAreaFieldClearTest() {
        webFormPage.inputTextareaValue(BIG_TEXT);
        webFormPage.clearTextareaValue();

        String bigText = webFormPage.getTextarea();
        assertThat(bigText).isEmpty();
    }

    @Test
    @DisplayName("Check Disabled input field")
    void disabledInputFieldTest() {
        assertFalse(webFormPage.disabledInput().isEnabled());

        assertThrows(ElementNotInteractableException.class, () -> webFormPage.disabledInput().sendKeys("test string"));

        assertEquals(DISABLED_INPUT_FIELD, webFormPage.getDisabledInputValue());
    }

    @Test
    @DisplayName("Check Readonly input field")
    void readonlyInputFieldTest() {
        assertTrue(webFormPage.readonlyInput().isEnabled());

        assertNotEquals("test string", webFormPage.readonlyInput().findElement(By.xpath("..")).getText());

        assertEquals(READONLY_INPUT_FIELD, webFormPage.getReadonlyInputField());
    }

    @ParameterizedTest(name = "Check Dropdown (select) menu by visible text")
    @ValueSource(strings = {"One", "Two", "Three"})
    public void dropdownSelectByVisibleTextTest(String option) {
        webFormPage.dropdownSelectorByVisibleText(option);
    }

    @ParameterizedTest(name = "Check Dropdown (select) menu by value")
    @ValueSource(strings = {"1", "2", "3"})
    public void dropdownSelectByValueTest(String value) {
        webFormPage.dropdownSelectorByValue(value);
    }

    @ParameterizedTest(name = "Check Dropdown (datalist) menu")
    @ValueSource(strings = {"San Francisco", "New York", "Seattle", "Los Angeles", "Chicago"})
    void dropdownDataListTest(String city) {
        webFormPage.dropDownDataListMenu(city);

        assertEquals(city, webFormPage.getDropdownDataList().getDomProperty(VALUE_NAME));
    }

    @Test
    @DisplayName("Check File input field")
    void fileInputTest() {
        webFormPage.downloadFile();
        webFormPage.submitForm();

        assertThat(driver.getCurrentUrl()).contains("STE+In+Banner");
    }

    @Test
    @DisplayName("Check checked Checkbox")
    void checkedCheckboxTest() {
        assertTrue(webFormPage.getCheckedCheckbox().isSelected());

        webFormPage.clickCheckedCheckbox();

        assertFalse(webFormPage.getCheckedCheckbox().isSelected());
    }

    @Test
    @DisplayName("Check default Checkbox")
    void defaultCheckboxTest() {
        assertFalse(webFormPage.getDefaultCheckbox().isSelected());

        webFormPage.clickDefaultCheckbox();

        assertTrue(webFormPage.getDefaultCheckbox().isSelected());
    }

    @Test
    @DisplayName("Check radio buttons")
    void radioButtonsTest() {
        assertTrue(webFormPage.getCheckedRadio().isSelected());
        assertFalse(webFormPage.getDefaultRadio().isSelected());

        webFormPage.clickDefaultRadio();

        assertFalse(webFormPage.getCheckedRadio().isSelected());
        assertTrue(webFormPage.getDefaultRadio().isSelected());
    }

    @Test
    @DisplayName("Check Color picker")
    void colorPickerTest() {
        String initColor = webFormPage.getColor();
        webFormPage.chooseColorPicker();
        String afterColor = webFormPage.getColor();

        assertThat(initColor).isNotEqualTo(afterColor);
        assertThat(Color.fromString(afterColor)).isEqualTo(GREEN);
    }

    @Test
    @DisplayName("Check Date picker")
    void datePickerTest() {
        webFormPage.chooseDatePicker("04/14/2025");

        assertEquals("04/14/2025", webFormPage.getDatePicker().getDomProperty(VALUE_NAME));
    }

    @Test
    @DisplayName("Check Example range")
    void actionAPIMouseExampleRangeTest() {
        webFormPage.moveSliderRight();

        assertEquals(String.valueOf(10), webFormPage.getRangeElement().getDomProperty(VALUE_NAME));
    }

    @Test
    @DisplayName("Check submit button and form submitted")
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
