import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_3.FormSubmittedPage;
import Ilya_S.pageObjects.chapter_3.WebFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_3.FormSubmittedPage.SUBMITTED_FORM_TEXT;
import static Ilya_S.pageObjects.chapter_3.FormSubmittedPage.SUBMITTED_FORM_TITLE;
import static Ilya_S.pageObjects.chapter_3.WebFormPage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class WebFormTests extends BaseTest {

    HomePage homePage;
    WebFormPage webFormPage;

    String userField = "user";
    String clearField = "";
    String passwordField = "user";

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
        webFormPage.inputValue();

        assertEquals(userField, webFormPage.getTextValue());
    }

    @Test
    void textInputClearTest() {
        webFormPage.inputValue();
        webFormPage.clearTextValue();

        assertEquals(clearField, webFormPage.getTextValue());
    }

    @Test
    void passwordInputTest() {
        webFormPage.inputPassword();

        assertEquals(passwordField, webFormPage.getTextPassword());
    }

    @Test
    void passwordClearTest() {
        webFormPage.inputPassword();
        webFormPage.clearPasswordValue();

        assertEquals(clearField, webFormPage.getTextPassword());
    }

    @Test
    void textAreaFieldTest() {
        webFormPage.inputTextareaValue();

        assertEquals(BIG_TEXT, webFormPage.getTextarea());
    }

    @Test
    void textAreaFieldClearTest() {
        webFormPage.inputTextareaValue();
        webFormPage.clearTextareaValue();

        assertEquals(clearField, webFormPage.getTextarea());
    }

    @Test
    void disabledInputFieldTest() {
        assertFalse(webFormPage.disabledInput().isEnabled());

        webFormPage.disabledInputFieldSendValue();

        assertEquals(DISABLED_INPUT_FIELD, webFormPage.getDisabledInputValue());
    }

    @Test
    void readonlyInputFieldTest() {
        assertTrue(webFormPage.readonlyInput().isEnabled());

        webFormPage.readonlyInputFieldSendValue();

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

        assertEquals(city, webFormPage.getDropdownDataList().getDomProperty("value"));
    }

    @Test
    void fileInputTest() {
        webFormPage.downloadFile();
        webFormPage.submitForm();

        assertThat(driver.getCurrentUrl()).contains("STE+In+Banner");

        FormSubmittedPage formSubmittedPage = new FormSubmittedPage(driver);
        WebElement title = webFormPage.getTitle();
        WebElement submittedText = formSubmittedPage.getSubmittedText();

        assertEquals(SUBMITTED_FORM_TITLE, title.getText());
        assertEquals(SUBMITTED_FORM_TEXT, submittedText.getText());
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

//    @Test
//    void colorPickerTest() throws InterruptedException {
//        assertThat(webFormPage.chooseColorPicker()).isNotEqualTo(initColor);
//        assertThat(Color.fromString(finalColor)).isEqualTo(green);
//        assertEquals("#00ff00", colorPicker.getAttribute("value"));
//    }

    @Test
    void datePickerTest() {
        webFormPage.chooseDatePicker();

        assertEquals("04/14/2025", webFormPage.getDatePicker().getDomProperty("value"));
    }

    @Test
    void actionAPIMouseExampleRangeTest() {
        webFormPage.moveSliderRight();

        assertEquals(String.valueOf(10), webFormPage.getRangeElement().getDomProperty("value"));
    }

    @Test
    void submitFormTest() throws InterruptedException {
        webFormPage.submitForm();
        Thread.sleep(3000);

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
