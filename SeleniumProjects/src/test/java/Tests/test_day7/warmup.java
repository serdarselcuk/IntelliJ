package Tests.test_day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class warmup {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver browser = new ChromeDriver();
        browser.get("http:cybertekscchool.com/");
        // finding every link that have been tagged as "a"(tagName = a)
        List<WebElement> links = browser.findElements(By.xpath("//a"));
        //number of links will be size of list
        //BE CAREFULLY ABOUT findElementS<===
//                if we have used findElement it would turn an exception when couldn't find element'
//                  but while using findElements there is no such kind of problrems
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i));
        }

        browser.quit();















    }
}
