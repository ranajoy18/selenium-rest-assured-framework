package common;

import java.time.Duration;


public class BaseTest {

    public static void setUp(){
        DriverManager.setWebDriver(DriverFactory.createWebDriver());
        DriverManager.getWebDriver().manage().window().maximize();
        DriverManager.getWebDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitDriver(){
        DriverManager.quitDriver();
    }

}
