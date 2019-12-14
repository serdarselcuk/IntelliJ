package Tests.test_day3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DifferenceBetweenQuitAndClose {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        browser.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(4000);


        browser.close();

       // browser.get("https//google.com");// it closed the tab we  cant call browser again
        //Thread.sleep(4000);

       browser.quit();

        // whats gone happen after we close the browser if we call again the browser()
        //browser.get("ghttps://google.com");
       // WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
        browser.get("http://practice.cybertekschool.com/open_new_tab");


    }
}
