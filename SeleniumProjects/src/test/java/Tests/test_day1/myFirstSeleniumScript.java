package Tests.test_day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class myFirstSeleniumScript {
    public static void main(String[] args) {


        //we have to setup webdriver based on the browser that we gonna use
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.iedriver().setup();

        //we need to create an object of appropriate class
        ChromeDriver driver = new ChromeDriver();
        //FirefoxDriver driver1 = new FirefoxDriver();

        //let's open google.com
//        .get method allows open some website
        driver.get("http://facebook.com");
        //driver1.get("http://facebook.com");

//        to read page title
        String actualResult = driver.getTitle();
        String expectedResult = "Google";

        if(actualResult.equals(expectedResult)){
            System.out.println("got it!");// if we writen on line 21: driver.get(http://google.com)
        }else{
            System.out.println("there is a problem!");// if we writen on line 21: driver.get(http://facebook.com)
        }
        driver.close();

    }
}
