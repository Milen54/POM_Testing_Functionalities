package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.base.WebApp;

public class BaseTest {

    protected WebDriver driver;
    protected WebApp webApp;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        webApp = new WebApp(driver);
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
