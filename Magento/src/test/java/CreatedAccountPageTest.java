import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CreatedAccountPage;
import pages.HomePage;
import pages.NewAccountPage;

public class CreatedAccountPageTest extends BaseTests {

    @Test
    public void createAnAccount() {
        HomePage homePage = new HomePage(driver);
        NewAccountPage accountPage = new NewAccountPage(driver);
        //go to account creation page
        homePage.navigateToCreatePage();
        //fill all mandatory fields
        accountPage.enterFirstName("Uros");
        accountPage.enterLastName("Matijasevic");
        accountPage.enterEmail("uroscodeacad@gmail.com");
        accountPage.enterPassword("Welcome01!");
        accountPage.enterConfirmedPassword("Welcome01!");
        accountPage.createNewAccount();
        //validate data of created account or if account already exists
        CreatedAccountPage createdAccountPage = new CreatedAccountPage(driver);
        createdAccountPage.validateCreation("Thank you for registering with Main Website Store.", "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.", "Uros Matijasevic", "uroscodeacademy@gmail.com");

    }
}
