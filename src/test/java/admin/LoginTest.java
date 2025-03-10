package admin;

import base.BaseTest;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @Test
    public void testLoginSuccessfully() {
        webApp.loginPage().goToLoginPage();
        webApp.loginPage().typeTextInUsernameInputField("admin");
        webApp.loginPage().typeTextInPasswordInputField("parola123!");
        webApp.loginPage().clickLoginButton();
        webApp.dashboardPage().verifyUsernameText("   John Doe");
    }

    @Test
    public void testLoginSuccessfully1() {
        webApp.loginPage().goToLoginPage();
        webApp.loginPage().login("admin", "parola123!");
        webApp.dashboardPage().verifyUsernameText("   John Doe");
    }

    @Test
    public void testLoginSuccessfully3() {
        webApp.loginPage().goToLoginPage();
        webApp.loginPage().typeTextInUsernameInputField("admin");
        webApp.loginPage().typeTextInPasswordInputField("parola123!");
        webApp.loginPage().clickLoginButton();
        webApp.dashboardPage().verifyUsernameText("   John Doe");
    }
}
