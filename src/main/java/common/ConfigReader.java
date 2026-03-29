package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties property=new Properties();

    static{
        try(InputStream in=ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")){
            property.load(in);
        }
         catch (IOException e) {
            throw new RuntimeException("config.properties not found",e);
        }
    }

    public static String getBrowser(){
        return property.getProperty("browser","chrome");
    }
    
    public static boolean getHeadless(){
        return Boolean.getBoolean(property.getProperty("headless","false"));
    }

    public static String getGridUrl(){
        return property.getProperty("grid.url", "to-do");
    }

}
