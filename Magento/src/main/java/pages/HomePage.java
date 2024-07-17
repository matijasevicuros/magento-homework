package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    private static final String hotSellersProductsLocator = "li.product-item";
    private static final String creationPageLocator = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a";
    @FindBy(css = hotSellersProductsLocator)
    private List<WebElement> hotSellersProducts;
    @FindBy(css = creationPageLocator)
    private WebElement creationPage;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart(Integer position) {
        waitForElementsToBeVisible(By.cssSelector(hotSellersProductsLocator));
        WebElement productToBuy = hotSellersProducts.get(position);
        click(productToBuy);
    }

    public void navigateToCreatePage() {
        waitForElementsToBeVisible(By.cssSelector(creationPageLocator));
        click(creationPage);

    }
}
