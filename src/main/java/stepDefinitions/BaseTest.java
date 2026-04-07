package stepDefinitions;

import common.DriverFactory;
import common.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;


public class BaseTest {

    @Before
    public static void setUp(){
        DriverManager.setWebDriver(DriverFactory.createWebDriver());
        DriverManager.getWebDriver().manage().window().maximize();
        DriverManager.getWebDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void quitDriver(){
        DriverManager.quitDriver();
    }

}
