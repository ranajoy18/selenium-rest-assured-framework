package common;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setUp(){
        DriverManager.setWebDriver(DriverFactory.createWebDriver());
        DriverManager.getWebDriver().manage().window().fullscreen();
    }

    @AfterTest
    public void quitDriver(){
        DriverManager.quitDriver();
    }

}
