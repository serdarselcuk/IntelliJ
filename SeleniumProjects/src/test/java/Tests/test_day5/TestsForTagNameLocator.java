package Tests.test_day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsForTagNameLocator {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();

        browser.get("http://practice.cybertekschool.com/sign_up");
        // if you want to do it in one line if you wont use the web element again :
        browser.findElement(By.name("full_name")).sendKeys("Test User");

        browser.findElement(By.name("email")).sendKeys("test_email@email.com");

        //browser.findElement(By.name("wooden_spoon")).click();

        browser.findElement(By.tagName("button")).click();
    }
}
