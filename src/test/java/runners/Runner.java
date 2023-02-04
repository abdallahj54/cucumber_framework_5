package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "steps",
        tags = "@Regression", //Empty means everything runs @Smoke only runs smoke and @Regression only runs regression
        dryRun = false
)
public class Runner {
}
