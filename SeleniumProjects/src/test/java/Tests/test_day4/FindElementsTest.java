package Tests.test_day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

public class FindElementsTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeDriver browser = new ChromeDriver();

        browser.get("http://practice.cybertekschool.com/forgot_password");
        // if you want to find an element use the ID becouse it is more specific
        String ExpectedTitle = browser.getTitle();
        System.out.println(ExpectedTitle);
        WebElement button = browser.findElement(By.id("form_submit"));
        // web element is an object that the selenium use
        //button.sendKeys("administraotr");
        BrowserUtils.wait(3);
        button.click();
        BrowserUtils.wait(3);
        String actualTitle = browser.getTitle();
        if (ExpectedTitle.equals(actualTitle)){
            System.out.println("test pass");
        }else{
            System.out.println("test failed "+ ExpectedTitle +"was expected but, "+ actualTitle+ "is actualized");
        }
        browser.quit();

    }
}
