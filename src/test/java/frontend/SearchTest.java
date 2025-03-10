package frontend;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.frontend.SearchPage;

import static org.testng.AssertJUnit.assertEquals;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchFunctionality() {
        webApp.searchPage().goToSearchPage();
        webApp.searchPage().searchFor("iPhone");

        String actualProductText = webApp.searchPage().getProductTitle();
        assertEquals("iPhone", actualProductText);

        System.out.println("actualProductText = " + actualProductText);
    }

}
