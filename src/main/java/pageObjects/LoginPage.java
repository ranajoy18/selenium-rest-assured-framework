package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath="//input[@name='username']")
    WebElement userName;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    @FindBy(xpath="/button[@id='submit']")
    WebElement submitButton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String username){
        userName.sendKeys(username);
    }

    public void enterPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickSubmit(){
        submitButton.click();
    }
}
