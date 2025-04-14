import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_5.ConsoleLogsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_5.ConsoleLogsPage.CONSOLE_LOGS_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleLogsTests extends BaseTest {

    @Test
    void openConsoleLogsTest() {
        HomePage homePage = new HomePage(driver);
        ConsoleLogsPage consoleLogsPage = homePage.openConsoleLogsPage();
        String currentUrl = consoleLogsPage.getCurrentUrl();
        WebElement title = consoleLogsPage.getTitle();
        String consoleLogsPageFormUrl = consoleLogsPage.getUrl();

        assertEquals(BASE_URL + consoleLogsPageFormUrl, currentUrl);
        assertEquals(CONSOLE_LOGS_FORM_TITLE, title.getText());
    }
}
