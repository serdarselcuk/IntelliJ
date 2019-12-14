package Tests.test_day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;
public class BitrixLogin {

    public static void main(String[] args) {

        int[] ser = {1,2};
        System.out.println(ser[3]);
        WebDriverManager.chromedriver().setup();;
        ChromeDriver browser = new ChromeDriver();
        browser.get("https://www.letgo.com/en-us/c/cars");
        browser.findElement(By.xpath("//input[@data-test = 'search-input']")).sendKeys("honda cr-v","ENTER", Keys.ENTER);

        BrowserUtils.wait(2);

        browser.findElement(By.xpath("/html/body/div/main/div[2]/div/div[3]/div/div/div[4]/div[2]/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/p/a")).click();
       // browser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("UserUser");
        BrowserUtils.wait(2);
//xpad syntax===>   tag name [@ attribute = value ]

    }
}class A{

}
//div[@class = 'price']
//p[contains(text(), 'miles')]