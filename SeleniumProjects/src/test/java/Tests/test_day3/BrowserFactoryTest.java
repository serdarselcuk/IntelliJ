package Tests.test_day3;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

class BrowserFactorTest {

    public static void main(String[] args) {
        WebDriver driverChrome = BrowserFactory.getDriver("chrome");
        // how can we print a source code of a page
        WebDriver driverFirefox = BrowserFactory.getDriver("firefox");

        driverChrome.get("http://practice.cybertekschool.com");

        System.out.println(driverChrome.getPageSource());

        driverChrome.quit();

        driverFirefox.get("http://practice.cybertekschool.com");

        System.out.println(driverFirefox.getPageSource().indexOf("password"));

        driverFirefox.quit();
    }
}
