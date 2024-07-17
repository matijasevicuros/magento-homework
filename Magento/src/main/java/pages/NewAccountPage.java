package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewAccountPage extends BasePage {
    private static final String firstNameInputLocator = "#firstname";
    private static final String lastNameInputLocator = "#lastname";
    private static final String emailInputLocator = "#email_address";
    private static final String passwordInputLocator = "#password";
    private static final String confirmedPasswordInputLocator = "#password-confirmation";
    private static final String createButtonLocator = "button[title='Create an Account']";

    @FindBy(css = firstNameInputLocator)
    private WebElement firstNameInput;

    @FindBy(css = lastNameInputLocator)
    private WebElement lastNameInput;

    @FindBy(css = emailInputLocator)
    private WebElement emailInput;

    @FindBy(css = passwordInputLocator)
    private WebElement passwordInput;

    @FindBy(css = confirmedPasswordInputLocator)
    private WebElement confirmedPasswordInput;

    @FindBy(css = createButtonLocator)
    private WebElement createButton;


    public NewAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstname) {
        firstNameInput.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastNameInput.sendKeys(lastname);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmedPassword(String confirmedPassword) {
        confirmedPasswordInput.sendKeys(confirmedPassword);
    }

    public void createNewAccount() {
        waitForElementsToBeVisible(By.cssSelector(createButtonLocator));
        click(createButton);
    }
}
