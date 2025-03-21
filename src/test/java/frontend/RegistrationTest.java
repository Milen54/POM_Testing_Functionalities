package frontend;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @Test
    public void RegisterTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        webApp.homePage().goToHomePage();
        webApp.homePage().openRegistrationSection();
        webApp.registerPage().fillRegistrationForm();


        webApp.successPage().verifyUrlContains("success&language");
        webApp.successPage().verifySuccessMessage("Your Account Has Been Created!");

    }

}
