package ActivityRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = "StepDefinition",
    tags = "@activity4"
)

public class ActivitiesRunner {

}
