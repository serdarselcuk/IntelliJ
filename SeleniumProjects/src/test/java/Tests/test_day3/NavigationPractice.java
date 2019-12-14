package Tests.test_day3;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class NavigationPractice {


    public static void main(String[] args)  {

        WebDriver driverChrome = BrowserFactory.getDriver("chrome");

        driverChrome.manage().window().maximize();

        driverChrome.get("https://google.com");

        BrowserUtils.wait(3);
        // to navigate different address on the same tab
        driverChrome.navigate().to("http://amazon.com");

        BrowserUtils.wait(3);
        // back to google...
        driverChrome.navigate().back();

        BrowserUtils.wait(3);
        // again forward to amazon
        driverChrome.navigate().forward();
        // refresh the page
        BrowserUtils.wait(3);

        driverChrome.navigate().refresh();

        BrowserUtils.wait(3);
        // close the browser
        driverChrome.quit();
    }
}
