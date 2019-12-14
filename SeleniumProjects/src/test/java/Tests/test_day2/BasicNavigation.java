package Tests.test_day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
//        before test we should setup web driver otherwise you could see exception error
        WebDriverManager.chromedriver().setup();
//        create the object in Chrome driver class
        ChromeDriver chrome = new ChromeDriver();
//        than you can easily get the page that you want to by using " .get()" command
        chrome.get("http://google.com");
//        if you want to open browser as maximazed you should use the line below
        chrome.manage().window().fullscreen();
//        chrome.get("http://google.com");
//        while navigating to the other page on the same browser URL must be passed as string or an object
        chrome.navigate().to("http://facebook.com");
        chrome.manage().window().maximize();
//we can get also the url on the browser
        System.out.println(chrome.getCurrentUrl()+"<======================= this");

//        selenium cannot close the browser automatically so that wed should close it
        chrome.close();// close will only close the current one
        chrome.quit();// this will shut down browser completely and after quit the chrome object is also been null

    }

}
