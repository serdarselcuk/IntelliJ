package Tests.test_day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsForIdLocator {

    public static void main(String[] args) {

//    <button class="btn btn-primary" onclick="button6()" name="button6" id="disappearing_button">Don't click!</button>
        WebDriverManager.chromedriver().setup();
        ChromeDriver browser = new ChromeDriver();
        browser.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button_6 = browser.findElementById("disappearing_button");

        button_6.click();

        WebElement result = browser.findElementById("result");

        browser.close();
        if(result.equals("Now it's gone!")){
            System.out.print("PASSED THE TEST");
        }else {
            System.out.print("PASSED THE TEST");
        }


    }

}
