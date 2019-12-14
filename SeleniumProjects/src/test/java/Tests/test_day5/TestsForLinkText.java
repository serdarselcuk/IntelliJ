package Tests.test_day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

public class TestsForLinkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();

        browser.get("http://practice.cybertekschool.com");
//       it works only if the tag is "a"
        browser.findElement(By.linkText("Autocomplete")).click();
        BrowserUtils.wait(3);
        browser.close();
    }
}
