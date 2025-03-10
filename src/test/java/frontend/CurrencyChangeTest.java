package frontend;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyChangeTest extends BaseTest {

    @Test
    public void testCurrencyChangeToEuro() {
        webApp.headerPage().goToSearchPage();
        webApp.headerPage().changeCurrencyToEuro();

        // TODO : create assertion for the currency

        WebElement productPrice = driver.findElement(By.xpath("//span[contains(text(), '€')]"));
        webApp.headerPage().jsScroll(productPrice);

        String actualPriceText = productPrice.getText();
        System.out.println("Намерена цена: " + actualPriceText);

        Assert.assertTrue(actualPriceText.contains("€"), "Цената не съдържа валутния символ (€)!");
    }

    @Test
    public void testCurrencyChangeToUSD() {
        webApp.headerPage().goToSearchPage();
        webApp.headerPage().changeCurrencyToUsd();

        WebElement productPrice = driver.findElement(By.xpath("//span[contains(text(), '$')]"));
        webApp.headerPage().jsScroll(productPrice);

        String actualPriceText = productPrice.getText();
        System.out.println("Намерена цена: " + actualPriceText);

        Assert.assertTrue(actualPriceText.contains("$"), "Цената не съдържа валутния символ ($)!");
    }
}
