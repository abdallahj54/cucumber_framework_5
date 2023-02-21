package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WikipediaPage;
import utils.Driver;

public class WikipediaSteps {

    WebDriver driver;
    WikipediaPage wikipediaPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        wikipediaPage = new WikipediaPage();
    }

    @When("user searches for {string} on Wikipedia")
    public void userSearchesForOnWikipedia(String key) {
        wikipediaPage.searchInput.sendKeys(key + Keys.ENTER);
    }

    @And("user should see {string} in the first heading")
    public void userShouldSeeInTheFirstHeading(String key) {
        Assert.assertTrue(wikipediaPage.firstHeading.isDisplayed());
        Assert.assertEquals(key, wikipediaPage.firstHeading.getText());
    }

    @Then("user should see below languages around the logo")
    public void user_should_see_below_languages_around_the_logo(DataTable languages){
        for (int i = 0; i < languages.asList().size(); i++) {
            System.out.println(languages.asList().get(i));
            Assert.assertEquals(languages.asList().get(i), wikipediaPage.mainLanguages.get(i).getText());
        }
    }
}
