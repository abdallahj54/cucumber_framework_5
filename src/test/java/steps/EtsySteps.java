package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.EtsyPage;
import utils.Driver;

public class EtsySteps {
    WebDriver driver;
    EtsyPage etsyPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        etsyPage = new EtsyPage();
    }
    @Then("user should see below categories in the header")
    public void userShouldSeeBelowCategoriesInTheHeader(DataTable categories) {
        for (int i = 0; i < categories.asList().size(); i++) {
            System.out.println(categories.asList().get(i));
            Assert.assertEquals(categories.asList().get(i), etsyPage.categoryList.get(i).getText());
        }
    }
}
