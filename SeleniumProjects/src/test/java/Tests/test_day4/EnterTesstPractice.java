package Tests.test_day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

public class EnterTesstPractice {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver browser = new ChromeDriver();

        browser.get("http://practice.cybertekschool.com/forgot_password");
        BrowserUtils.wait(4);
        WebElement username = browser.findElementByName("email");
        username.sendKeys("random@email.com", Keys.ENTER);

        String expectedResult = "http://practice.cybertekschool.com/email_sent";
        String actualizedResult = browser.getCurrentUrl();

        if(expectedResult.equals(actualizedResult)) {
            System.out.println("Test Passed");
        }else{
            System.out.println("test failed : expected ; "+ expectedResult + " but actualized "+ actualizedResult);
            }
        WebElement conf_message = browser.findElementByName("confirmation_message");
        String actualMessage = conf_message.getText();
        String expectedMessage = "Your e-mail's been sent!";
        if(!expectedMessage.equals(actualMessage) ){
            System.out.println("message is differen : "+ actualMessage);
        }
                BrowserUtils.wait(2);
        browser.quit();


    }
}
