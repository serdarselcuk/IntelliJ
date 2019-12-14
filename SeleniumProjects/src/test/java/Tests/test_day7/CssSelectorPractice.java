package Tests.test_day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {

    public static void main(String[] args) {
//        Which locator should we use
//        1) id
//        2) css
//        3) xpath

        WebDriver browser = BrowserFactory.getDriver("chrome");
        browser.get("http://practice.cybertekschool.com/multiple_buttons");

//        if there is a space in class name it means it has 2 class name and you should put there a dot
        List <WebElement> buttons = browser.findElements(By.cssSelector(".btn.btn-primary"));
        //                          you can also use in that way =====> [class='btn btn-primary']

        for (WebElement each :
                buttons)   {
                       each.click();
            BrowserUtils.wait(2);
            String message = browser.findElement(By.cssSelector("#result")).getText();
            System.out.println(message);
        }
        //[class='container']>button ==> can be useful also

        browser.quit();
    }
}
