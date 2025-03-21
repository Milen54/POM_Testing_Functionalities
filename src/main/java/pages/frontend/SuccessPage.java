package pages.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;

import java.time.Duration;

public class SuccessPage{

    private WebDriver driver;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyUrlContains(String partialUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("success&language"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(partialUrl), "You are not on the right page!");

    }

    public void verifySuccessMessage(String expectedMessage) {
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='col']/h1"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(actualText, expectedMessage, "Неуспешно създаване на акаунт!");
        System.out.println(expectedMessage);
    }

}
