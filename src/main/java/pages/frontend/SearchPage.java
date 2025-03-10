package pages.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchBox;

    @FindBy(xpath = "//i[@class='fa-solid fa-magnifying-glass']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[text()='iPhone']")
    private WebElement productTitle;

    private static final String frontendURL = "https://auto.pragmatic.bg/index.php?route=common/home&language=en-gb";

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToSearchPage() {
        driver.get(frontendURL);
    }

    public void searchFor(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

}
