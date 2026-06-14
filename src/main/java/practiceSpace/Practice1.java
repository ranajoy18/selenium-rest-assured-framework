package practiceSpace;

import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.openqa.selenium.WebDriver;

public class Practice1 {

    public static void main(String []args){

        WebDriver driver=new ChromeDriver();
        String url="https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
        String filePath =System.getProperty("user.home")+ "/Downloads/dummy.pdf";
        try{
            getFileDownload(driver,url,filePath);
            System.out.println("File downloaded successfully");
        }
        catch(Exception e){
            
            System.out.println("Operation failed :"+e.getMessage());
        }
        driver.quit();
    }
    public static void getFileDownload(WebDriver driver, String url,String filePath) throws Exception{

        driver.get(url);

        File file=new File(filePath);
        if(!file.exists()){
            throw new Exception("File failed to download");
        }
        if(file.length()==0){
            throw new Exception("File is empty");
        }
    }
    
}
