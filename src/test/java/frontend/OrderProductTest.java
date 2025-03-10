package frontend;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomEmailGenerator;

public class OrderProductTest extends BaseTest {

    @Test
    public void addToCartTest () {
        webApp.searchPage().goToSearchPage();
        webApp.searchPage().searchFor("iPhone");
        webApp.productPage().scrollToAddToCart();
        webApp.productPage().addToCart();
        webApp.productPage().clickCartButton();

        webApp.productPage().clickCheckout();

        String actualHeader = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println("Actual header text: " + actualHeader);

        Assert.assertEquals(actualHeader, "Checkout", "Checkout header does not match!");

        String randomEmail = RandomEmailGenerator.generateRandomEmail();
        System.out.println("The email is: " + randomEmail);

        webApp.checkoutPage().fillRegistrationForm("Milen", "Denkov", randomEmail, "street Benkovski", "Sofia", "1000", "passcode123");
        webApp.checkoutPage().selectCountry("Bulgaria");
        webApp.checkoutPage().selectRegion("Sofia - town");
        webApp.checkoutPage().clickContinueButton();
        webApp.checkoutPage().choseShippingMethod();
        webApp.checkoutPage().chosePaymentMethod();
        webApp.orderConfirmationPage().verifyOrderStatus();

    }

}

