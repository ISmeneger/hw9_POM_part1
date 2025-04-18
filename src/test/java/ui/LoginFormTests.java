package ui;

import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_7.LoginFormPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_7.LoginFormPage.LOGIN_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginFormTests extends BaseTest {

    @Test
    void openLoginFormTest() {
        HomePage homePage = new HomePage(driver);
        LoginFormPage loginFormPage = homePage.openLoginFormPage();
        String currentUrl = loginFormPage.getCurrentUrl();
        WebElement title = loginFormPage.getTitle();
        String loginFormPageFormUrl = loginFormPage.getUrl();

        assertEquals(BASE_URL + loginFormPageFormUrl, currentUrl);
        assertEquals(LOGIN_FORM_TITLE, title.getText());
    }
}
