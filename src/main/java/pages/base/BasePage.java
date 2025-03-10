package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }

    public String getWebElementAttribute(WebElement element, String nameOfTheAttribute) {
        return element.getDomProperty(nameOfTheAttribute);
    }

    public String getWebElementAttributeByLocator(By locator, String nameOfTheAttribute) {
        return driver.findElement(locator).getDomProperty(nameOfTheAttribute);
    }

    public void typeText(WebElement element, String textToTypeInTheElement) {
        element.sendKeys(textToTypeInTheElement);
    }

    public void typeTextByLocator(By locator, String textToTypeInTheElement) {
        driver.findElement(locator).sendKeys(textToTypeInTheElement);
    }

    public void jsScroll(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void clickButton(WebElement button) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

}
