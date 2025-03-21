package pages.frontend;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class HomePage extends BasePage {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//span[@class='d-none d-md-inline' and text()='My Account']")
    private WebElement myAccountButton;

    @FindBy (xpath = "//ul[@class='dropdown-menu dropdown-menu-right show']//a[contains(@class, 'dropdown-item') and text()='Register']")
    private WebElement registerButton;

    private static final String frontendURL = "https://auto.pragmatic.bg/index.php?route=common/home&language=en-gb";

    public void goToHomePage() {
        driver.get(frontendURL);
    }

    public void openRegistrationSection() {
        clickButton(myAccountButton);
        clickButton(registerButton);
    }
}
