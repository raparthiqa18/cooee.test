package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@Test",
        glue={"Steps"},
        plugin = { "pretty", "html:target/cucumber/report.html","json:target/cucumber/report.json" },
//        plugin =  {"pretty","json:target/cucumber.json"}
        publish = true
)

public class Testrunner {
}
