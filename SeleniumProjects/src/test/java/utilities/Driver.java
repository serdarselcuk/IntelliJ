package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static RemoteWebDriver driver;

    // private constructor doesn't allow creating object
    private Driver(){ }

    public static RemoteWebDriver get(){
        if (driver == null){
            String browser = ConfigurationReader.getProperty(("browser"));
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                default:
                    throw new RuntimeException(" Wrong Browser Type ???");
            }
        }
        return driver;
    }
    public static void close(){
        // if driver still exist
        if(driver!=null){
            driver.quit();
            //ready for garbage collector

        }driver = null;
    }
}
