package pages.base;

import org.openqa.selenium.WebDriver;
import pages.admin.DashboardPage;
import pages.admin.LoginPage;
import pages.frontend.*;

public class WebApp {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private SearchPage searchPage;
    private HeaderPage headerPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
    private ShoppingCartPage shoppingCartPage;
    private OrderConfirmationPage orderConfirmationPage;

    public WebApp(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(driver);
        }
        return dashboardPage;
    }

    public SearchPage searchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage(driver);
        }
        return searchPage;
    }

    public HeaderPage headerPage() {
        if (headerPage == null) {
            headerPage = new HeaderPage(driver);
        }
        return headerPage;
    }

    public ProductPage productPage() {
        if(productPage == null) {
            productPage = new ProductPage(driver);
        }
        return productPage;
    }

    public CheckoutPage checkoutPage() {
        if(checkoutPage == null){
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }

    public ShoppingCartPage shoppingCartPage() {
        if(shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage(driver);
        }
        return shoppingCartPage;
    }

    public OrderConfirmationPage orderConfirmationPage() {
        if (orderConfirmationPage == null) {
            orderConfirmationPage = new OrderConfirmationPage(driver);
        }
        return orderConfirmationPage;
    }

    public void quit() {
        driver.quit();
    }
}
