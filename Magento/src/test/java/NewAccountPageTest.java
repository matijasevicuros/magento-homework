import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.NewAccountPage;


public class NewAccountPageTest extends BaseTests {

    @Test
    public void createAnAccount() {
        HomePage homePage = new HomePage(driver);
        NewAccountPage accountPage = new NewAccountPage(driver);
        homePage.navigateToCreatePage();
        accountPage.enterFirstName("Uros");
        accountPage.enterLastName("Matijasevic");
        accountPage.enterEmail("creationacctest@gmail.com");
        accountPage.enterPassword("Welcome01!");
        accountPage.enterConfirmedPassword("Welcome01!");
        accountPage.createNewAccount();
    }
}
