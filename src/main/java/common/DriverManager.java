package common;

import org.openqa.selenium.WebDriver;


public class DriverManager {

    private static final ThreadLocal<WebDriver>  driverThread=new ThreadLocal<>();

    public static void setWebDriver(WebDriver driver){
        driverThread.set(driver);
    }

    public static WebDriver getWebDriver(){
        return driverThread.get();
    }

    public static void quitDriver(){
        System.out.println("Quitting driver...");
        if(driverThread.get()!=null){
            driverThread.get().quit();
            driverThread.remove();
        } else {
            System.out.println("Driver is null");
        }
    }
}
