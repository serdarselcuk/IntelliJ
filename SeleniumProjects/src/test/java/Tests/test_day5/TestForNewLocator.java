package Tests.test_day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TestForNewLocator
{
    public static void main(String[] args) {

        // remember for mac saafari browser users they don't need to use webdriver manager it has already build in safari
        WebDriver browser = BrowserFactory.getDriver("chrome");
        browser.manage().window().maximize();
        browser.get("http://practice.cybertekschool.com/sign_up");
        // if you want to do it in one line if you wont use the webelement again :
        browser.findElement(By.name("full_name")).sendKeys("Test User");

        browser.findElement(By.name("email")).sendKeys("test_email@email.com");

        browser.findElement(By.name("wooden_spoon")).click();

        BrowserUtils.wait(2);
        browser.close();



    }
}
