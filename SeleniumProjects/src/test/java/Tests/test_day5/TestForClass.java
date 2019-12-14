package Tests.test_day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestForClass {
 protected String serdar = "seerdar";
 private  String sel = "sel";
 public String sen= "sen";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();

        browser.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println(browser.findElement(By.className("h3")).getText());

        browser.close();
    }

}
