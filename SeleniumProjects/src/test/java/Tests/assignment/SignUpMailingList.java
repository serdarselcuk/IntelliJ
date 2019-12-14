package Tests.assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class SignUpMailingList {

        public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            ChromeDriver browser = new ChromeDriver();
            browser.get("https://practice-cybertekschool.herokuapp.com/sign_up");
            browser.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[1]/div/input")).sendKeys("serdar");
            browser.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[2]/div/input")).sendKeys("sersel@gmail.com");
            browser.findElement(By.xpath("/html/body/div/div[2]/div/div/form/button")).click();
            String result = browser.findElement(By.xpath("/html/body/div/div[2]/div/div/a/i")).getText();

            if (result.equals("Home")){

                System.out.println("test passed");
            }else{
                System.out.println("test failed" + result + "was the message");
            }
            browser.close();
        }
}
