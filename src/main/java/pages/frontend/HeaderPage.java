package pages.frontend;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class HeaderPage extends BasePage {

    JavascriptExecutor js = (JavascriptExecutor) driver;


    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[contains(@class, 'fa-caret-down')]")
    private WebElement currencyDropdown;

    @FindBy(xpath = "//a[contains(@href, 'EUR')]")
    private WebElement euroCurrency;

    @FindBy(xpath = "//a[contains(@href, 'USD')]")
    private WebElement usdCurrency;

    private static final String frontendURL = "https://auto.pragmatic.bg/index.php?route=common/home&language=en-gb";

    public void goToSearchPage() {
        driver.get(frontendURL);
    }

    public void changeCurrencyToEuro() {
        currencyDropdown.click();
        euroCurrency.click();
    }

    public void changeCurrencyToUsd() {
        currencyDropdown.click();
        usdCurrency.click();
    }

    public void jsScroll(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
