import Ilya_S.pageObjects.HomePage;
import Ilya_S.pageObjects.chapter_4.InfiniteScrollPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static Ilya_S.pageObjects.HomePage.BASE_URL;
import static Ilya_S.pageObjects.chapter_4.InfiniteScrollPage.INFINITE_SCROLL_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InfiniteScrollTests extends BaseTest {

    @Test
    void openInfiniteScrollTest() {
        HomePage homePage = new HomePage(driver);
        InfiniteScrollPage infiniteScrollPage = homePage.openInfiniteScrollPage();
        String currentUrl = infiniteScrollPage.getCurrentUrl();
        WebElement title = infiniteScrollPage.getTitle();
        String infiniteScrollPageFormUrl  = infiniteScrollPage.getUrl();

        assertEquals(BASE_URL + infiniteScrollPageFormUrl, currentUrl);
        assertEquals(INFINITE_SCROLL_FORM_TITLE, title.getText());
    }
}
