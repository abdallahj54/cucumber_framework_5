package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "steps",
        tags = "@Login", //Empty means everything runs @Smoke only runs smoke and @Regression only runs regression
        dryRun = false, //true, it doesn't run an automation, but it shows all undefined steps (false, it will run the automation)
        monochrome = false,
        plugin = {"html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json",
                "pretty"}
)
public class Runner {
}
