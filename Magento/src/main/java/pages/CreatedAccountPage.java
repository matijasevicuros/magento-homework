package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreatedAccountPage extends BasePage {
    private static final String successMessageLocator = "div.message-success";
    private static final String accountInfoLocator = "div.box-information";
    private static final String errorMessageLocator = "div.message-error";
    @FindBy(css = successMessageLocator)
    private WebElement successMessage;
    @FindBy(css = accountInfoLocator)
    private WebElement accountInfo;
    @FindBy(css = errorMessageLocator)
    private WebElement errorMessage;

    public CreatedAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateAccountInfo(String expectedFirstLastName, String expectedEmail) {
        waitForElementsToBeVisible(By.cssSelector(accountInfoLocator));
        String actualAccountInfo = accountInfo.getText();
        Assertions.assertTrue(actualAccountInfo.contains(expectedFirstLastName), "Uros Matijasevic");
        Assertions.assertTrue(actualAccountInfo.contains(expectedEmail), "uroscodeacad@gmail.com");
    }

    public void validateCreation(String expectedSuccessMessage, String expectedErrorMessage, String expectedFirstLastName, String expectedEmail) {
        try {
            //get element text
            waitForElementsToBeVisible(By.cssSelector(successMessageLocator));
            String actualSuccessMessage = successMessage.getText();
            Assertions.assertEquals(expectedSuccessMessage, actualSuccessMessage);
            validateAccountInfo(expectedFirstLastName, expectedEmail);
        } catch (Exception e) {
            try {
                waitForElementsToBeVisible(By.cssSelector(errorMessageLocator));
                String actualErrorMessage = errorMessage.getText();
                Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
            } catch (Exception ex) {
                Assertions.fail("Neither success nor error message was found.");
            }
        }
    }
}
