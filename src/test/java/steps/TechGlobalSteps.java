package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utils.AlertHandler;
import utils.Driver;
import utils.Waiter;

public class TechGlobalSteps {


    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalAlertsPage techGlobalAlertsPage;
    TechGlobalLoginFormPage techGlobalLoginFormPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }

    @When("user clicks on Practices dropdown in the header")
    public void userClicksOnPracticesDropdownInTheHeader() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
    }

    @And("user selects the {string} option")
    public void userSelectsTheOption(String option) {
        switch (option) {
            case "Frontend Testing":
                techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
                break;
            case "Dynamic Tables":
            case "Alerts":
            case "Login Form":
                techGlobalFrontendTestingHomePage.clickOnCard(option);
                break;
            default:
                throw new NotFoundException();
        }
    }

    @Then("user should see {string} heading")
    public void userShouldSeeHeading(String headerText) {
        switch (headerText) {
            case "Dynamic Tables":
                Assert.assertEquals(headerText, techGlobalDynamicTablesPage.headingText.getText());
                break;
            case "Alerts":
                Assert.assertEquals(headerText, techGlobalAlertsPage.headingText.getText());
                break;
            case "Login Form":
                Assert.assertEquals(headerText, techGlobalLoginFormPage.headingText.getText());
                break;
            default:
                throw new NotFoundException("The heading text is not defined!");
        }
    }

    @When("user clicks the {string} button")
    public void userClicksTheButton(String argument) {
        switch (argument) {
            case "ADD PRODUCT":
                techGlobalDynamicTablesPage.addProductButton.click();
                break;
            case "CLOSE":
                techGlobalDynamicTablesPage.closeButton.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file");
        }
    }

    @Then("validate {string} pop-up is displayed")
    public void validatePopUpIsDisplayed(String popup) {
        Assert.assertEquals(popup, techGlobalDynamicTablesPage.modalCardTitle.getText());
    }

    @Then("user should not see Add New Product pop-up")
    public void userShouldNotSeeAddNewProductPopUp() {
        try {
            Assert.assertFalse(techGlobalDynamicTablesPage.modalCardTitle.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    @And("user should see buttons as below")
    public void userShouldSeeButtonsAsAnd(DataTable warningButtons) {
        for (int i = 0; i < warningButtons.asList().size(); i++) {
            Assert.assertEquals(warningButtons.asList().get(i), techGlobalAlertsPage.alertButtons.get(i).getText());
        }
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String resulText) {
        Assert.assertEquals(resulText, techGlobalAlertsPage.resultTitle.getText());
    }

    @When("user clicks on {string} box")
    public void userClicksOnBox(String alertButton) {
        techGlobalAlertsPage.clickOnAlert(alertButton);
    }

    @Then("user should see a popup displaying message {string}")
    public void userShouldSeeAPopupDisplayingMessage(String alertMessage) {
        Waiter.pause(2);
        Assert.assertEquals(alertMessage, AlertHandler.getAlertText());
        Waiter.pause(2);
        AlertHandler.acceptAlert();
    }

    @When("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        techGlobalLoginFormPage.username.sendKeys(username);
        techGlobalLoginFormPage.password.sendKeys(password);
        techGlobalLoginFormPage.loginButton.click();
    }

    @Then("user should see a {string} message")
    public void userShouldSeeAMessage(String message) {
        switch (message) {
            case "Invalid Username entered!":
            case "Invalid Password entered!":
                Assert.assertEquals(message, techGlobalLoginFormPage.errorMessage.getText());
                break;
            case "You are logged in":
                Assert.assertEquals(message, techGlobalLoginFormPage.successLoginText.getText());
                break;
            default:
                throw new NotFoundException("The error message is not defined properly in the feature file");
        }
    }
}