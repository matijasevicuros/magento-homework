import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.NewAccountPage;

import java.time.Duration;

public class HomePageProductsTest extends BaseTests{

    @Test
    public void validateItem() {
        HomePage homePage = new HomePage(driver);
        homePage.addItemToCart(2);
    }
}
