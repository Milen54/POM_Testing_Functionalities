package pages.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

public class ProductPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='submit']/i[@class='fa-solid fa-shopping-cart']")
    private WebElement addToCartBtn;

    public void scrollToAddToCart() {
        jsScroll(addToCartBtn);
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
    }

    public void addToCart () {
        scrollToAddToCart();
        addToCartBtn.click();
    }

    @FindBy(xpath = "//button[@data-bs-toggle='dropdown']")
    private WebElement cartButton;

    @FindBy(xpath = "//strong//i[@class='fa-solid fa-cart-shopping']")
    private WebElement viewCartBtn;

    public void clickCartButton() {
        jsScroll(cartButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("alert-success")));
        cartButton.click();
        viewCartBtn.click();
    }

    @FindBy (xpath = "//a[@class='btn btn-primary']")
    private WebElement checkoutBtn;

    public void clickCheckout() {
        jsScroll(checkoutBtn);
        wait.until(ExpectedConditions.visibilityOfAllElements(checkoutBtn));
        checkoutBtn.click();
    }

}
