package Tests.test_day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_day3 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        ChromeDriver browser = new ChromeDriver();

        browser.get("https://qa2.vytrack.com");

/*

        browser.username = new browser.findElementById("prependedInput");
        username.clear();
        username.(" ");

        Vector password = (Vector) browser.findElementByName("_password");
        password.clear();
        password.send_keys(" ");
*/
    }
}
