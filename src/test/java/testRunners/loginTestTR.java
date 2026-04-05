package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/LoginTest.feature",
    glue = "stepDefinations",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/LoginReport.html"
    },
    monochrome = true
)
public class LoginTestTR extends AbstractTestNGCucumberTests {
}