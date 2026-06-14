package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/LoginReport.html"
        },
        monochrome = true,
        tags = "@login"
)
public class LoginTest extends AbstractTestNGCucumberTests {


}