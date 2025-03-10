package pages.frontend;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy (xpath = "//*[@id='input-firstname']")
    private WebElement firstNameField;

    @FindBy (xpath = "//*[@id='input-lastname']")
    private WebElement lastNameField;

    @FindBy (xpath = "//*[@id='input-email']")
    private WebElement emailField;

    @FindBy (xpath = "//*[@id='input-shipping-address-1']")
    private WebElement addressField;

    @FindBy (id = "input-shipping-city")
    private WebElement cityField;

    @FindBy (xpath = "//*[@id='input-shipping-postcode']")
    private WebElement postCodeInput;

    @FindBy (id = "input-shipping-country")
    private WebElement countryDropdown;

    @FindBy (id = "input-shipping-zone")
    private WebElement regionDropdown;

    @FindBy (id = "input-password")
    private WebElement passwordField;

    @FindBy (id = "input-register-agree")
    private WebElement checkBoxPrivacyPolicy;

    @FindBy (xpath = "//button[text()='Confirm Order']")
    private WebElement confirmOrderButton;

    @FindBy (xpath = "//*[@id='button-register']")
    private WebElement continueButton;

    @FindBy (id = "button-shipping-methods")
    private WebElement choseShippingMethodButton;

    @FindBy (id = "input-shipping-method-flat-flat")
    private WebElement flatShippingRate;

    @FindBy (id = "button-shipping-method")
    private WebElement flatRateContinueButton;

    @FindBy (id = "button-payment-methods")
    private WebElement chosePaymentMethodButton;

    @FindBy (id = "input-payment-method-cod-cod")
    private WebElement cashOnDeliveryButton;

    @FindBy (id = "button-payment-method")
    private WebElement paymentMethodContinueButton;

    @FindBy (xpath = "//div[@id='search']//i[contains(@class, 'fa-magnifying-glass')]")
    private WebElement searchButton;

    @FindBy (id = "button-confirm")
    private WebElement confirmOrderButtonFinal;

    public void fillRegistrationForm(String firstName, String lastName, String email, String address, String city, String postCode, String password) {
        typeText(firstNameField, firstName);
        typeText(lastNameField, lastName);
        jsScroll(confirmOrderButton);
        typeText(emailField, email);
        typeText(addressField, address);
        typeText(cityField, city);
        typeText(postCodeInput, postCode);
        typeText(passwordField, password);
        checkBoxPrivacyPolicy.click();

    }

    public void selectCountry(String countryName) {
        Select makeDropdown = new Select(countryDropdown);
        makeDropdown.selectByVisibleText(countryName);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("input-shipping-zone")));
    }


    public void selectRegion(String regionName) {
        Select makeDropdown = new Select(regionDropdown);
        makeDropdown.selectByVisibleText(regionName);
    }

    public void clickContinueButton() {
        clickButton(continueButton);
    }

    public void choseShippingMethod()  {
        jsScroll(searchButton);
        jsClick(choseShippingMethodButton);
        wait.until(ExpectedConditions.elementToBeClickable(flatShippingRate));
        clickButton(flatShippingRate);
        wait.until(ExpectedConditions.elementToBeClickable(flatShippingRate));
        clickButton(flatRateContinueButton);
    }

    public void chosePaymentMethod() {
       clickButton(chosePaymentMethodButton);
       clickButton(cashOnDeliveryButton);
       clickButton(paymentMethodContinueButton);
       clickButton(confirmOrderButtonFinal);
    }

}
