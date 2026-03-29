package common;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {

    public static WebDriver createWebDriver(){
        String browser=ConfigReader.getBrowser().toLowerCase();
        boolean headless=ConfigReader.getHeadless();
        String gridUrl=ConfigReader.getGridUrl();

        MutableCapabilities capabilities=switch (browser) {
            case "firefox"-> buildFireFoxOptions(headless);
            case "safari"-> new SafariOptions();
            case "edge"-> buildEdgeOptions(headless);
            default-> buildChromeOptions(headless);
        };

        if(!gridUrl.isEmpty()){
            try{
                return new RemoteWebDriver(new URL(gridUrl),capabilities);
            }
            catch(MalformedURLException e){
                throw new RuntimeException("Invalid grid URL: " + gridUrl, e);
            }
        }

        return switch(browser){
            case "firefox" -> new FirefoxDriver((FirefoxOptions)capabilities);
            case "edge" -> new EdgeDriver((EdgeOptions)capabilities);
            case"safari" -> new SafariDriver((SafariOptions)capabilities);
            default ->new ChromeDriver((ChromeOptions)capabilities);
            };
    }

    private static ChromeOptions buildChromeOptions(boolean headless) {
        ChromeOptions option=new ChromeOptions();
        option.addArguments("--headless=new");
        return option;
    }

    private static EdgeOptions buildEdgeOptions(boolean headless) {
        EdgeOptions option=new EdgeOptions();
        option.addArguments("-headless");
        return option;
    }

    private static FirefoxOptions buildFireFoxOptions(boolean headless) {
        FirefoxOptions option=new FirefoxOptions();
        option.addArguments("-headless");
        return option;
    }
}