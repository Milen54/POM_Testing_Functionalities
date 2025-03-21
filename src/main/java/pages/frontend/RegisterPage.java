package pages.frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import utils.RandomEmailGenerator1;

import java.time.Duration;

public class RegisterPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "input-firstname")
    private WebElement firstNameField;

    @FindBy (id = "input-lastname")
    private WebElement lastNameField;

    @FindBy (id = "input-email")
    private WebElement emailField;

    @FindBy (id = "input-password")
    private WebElement passwordField;

    @FindBy (xpath = "//input[@name='agree']")
    private WebElement radioButtonPolicy;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    private WebElement continueButton;

    public void fillRegistrationForm(){
        typeText(firstNameField, "Milen");
        typeText(lastNameField, "Kirilov");
        typeText(passwordField, "123456");

        String randomEmail = RandomEmailGenerator1.generateRandomEmail();

        System.out.println("Имейлът е: " + randomEmail);

        emailField.sendKeys(randomEmail);

        jsScroll(radioButtonPolicy);
        wait.until(ExpectedConditions.visibilityOf(radioButtonPolicy));
        wait.until(ExpectedConditions.elementToBeClickable(radioButtonPolicy));

        clickButton(radioButtonPolicy);
        clickButton(continueButton);
    }
}
