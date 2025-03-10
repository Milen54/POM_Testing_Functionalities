package pages.frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class ShoppingCartPage extends BasePage {


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='shopping-cart']//a[contains(text(), 'iPhone')]")
    public WebElement expectedProduct;

    public String getProductNameInCart() {
        return expectedProduct.getText();
    }


}
