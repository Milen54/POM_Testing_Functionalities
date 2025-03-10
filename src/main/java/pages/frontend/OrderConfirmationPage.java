package pages.frontend;

import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.base.BasePage;

public class OrderConfirmationPage extends BasePage {

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='content']//h1")
    private WebElement orderHeader;

    public void verifyOrderStatus() {
       String expectedText = orderHeader.getText();
        Assert.assertEquals(expectedText, "Your order has been placed!");
        System.out.println(expectedText);
    }

}
