package Tests.test_day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class JsExecuter {
    WebDriver driver;

    @Test(description = "Drag And Drop")
    public void Practice() {

        driver = BrowserFactory.getDriver("chrome");
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;  //  casting is here !!!

        for (int i = 0; i < 50; i++) {
            js.executeScript("window.scrollBy(0,500)");
            BrowserUtils.wait(1);
        }

    }

    @Test(description = "Drag And Drop")
    public void Practice2() {

        driver = BrowserFactory.getDriver("chrome");
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", link);//arguments[0] is shows the link. we can give more arguments
        BrowserUtils.wait(1);
    }

    @Test(description = "click by js")
    public void clicking() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link = driver.findElement((By.partialLinkText("Example 1")));

        WebElement link1 = driver.findElement((By.partialLinkText("Example 1")));

        BrowserUtils.wait(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments [1].click()", link, link1);
    }

    @AfterMethod
    public void closure() {

        driver.close();
    }

    @Test(description = "click by js")
    public void setAttribute() {
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.name("wooden_spoon"));
        //to create javascriptexecutor object we need to cast webdriver object
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        //enter full name
        //arguments[0].setAttribute('value', 'John Smith') it's the same as name.sendKeys("John Smith");
        BrowserUtils.wait(2);
        driver.executeScript("arguments[0].setAttribute('value', 'John Smith')", name);
        BrowserUtils.wait(2);
        driver.executeScript("arguments[0].setAttribute('value', 'someemail@email.com')", email);
        BrowserUtils.wait(2);
        driver.executeScript("arguments[0].click()", submitButton);
        BrowserUtils.wait(2);
    }
}

