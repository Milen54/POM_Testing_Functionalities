package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy (id = "input-username")
    private WebElement usernameInputField;

    @FindBy (id = "input-password")
    private WebElement passwordInputField;

    @FindBy (className = "btn-primary")
    private WebElement loginButton;

    private static final String URL = "https://auto.pragmatic.bg/manage";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        driver.get(URL);
    }

    public void login(String username, String password) {
        typeTextInUsernameInputField(username);
        typeTextInPasswordInputField(password);
        clickLoginButton();
    }

    public void typeTextInUsernameInputField(String username) {
        typeText(usernameInputField, username);
    }

    public void typeTextInPasswordInputField(String password) {
        typeTextByLocator(By.id("input-password"), password);
    }

    public void clickLoginButton() {
       loginButton.click();
    }

}
