package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;
import utils.WaitTool;

import java.time.Duration;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//*[@class='fa-solid fa-caret-down fa-fw']/ ..")
    private WebElement username;

    private static final By USERNAME = By.xpath("//*[@class='fa-solid fa-caret-down fa-fw']/ ..");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String usernameGetText() {
        return username.getText();
    }

    public String usernameGetTextByLocator() {
        return driver.findElement(USERNAME).getText();
    }

    public void verifyUsernameText(String expectedUsername) {
        WaitTool.waitForElement(driver, USERNAME, 10);
        Assert.assertEquals(usernameGetText(), expectedUsername);
    }
}
