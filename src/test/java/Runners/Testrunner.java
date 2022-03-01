package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@Test",
        glue={"Steps"},
        plugin = { "pretty", "html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json" }
)

public class Testrunner {}
