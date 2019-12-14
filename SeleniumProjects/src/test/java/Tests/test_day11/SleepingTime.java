package Tests.test_day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SleepingTime {
    private ChromeDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        }

    @BeforeMethod
    public void navigate(){
        driver.navigate().to("http://practice.cybertekschool.com/");
    }
    @Test(description = "implicitWait")
    public void Test1(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()='Dynamic Loading']")).click();
        driver.findElement(By.xpath("//a[starts-with(text(),'Example 2')]")).click();
        driver.findElement(By.xpath("//button")).click();

        String text = driver.findElement(By.id("finish")).getText();
        System.out.println(text);
        Assert.assertEquals(text,"Hello World!");

    }
    @Test(description = "explicitWait ")
    public void test2(){

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.xpath("//button")).click();
        WebElement userName = driver.findElement(By.id("username"));
        //element is exist oyu can select  but not visible so we are waiting to send the keys...
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys(" tomsmith");
        driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");



    }
    @Test(description = "...")
   public void test3(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();

//        driver.findElement(By.xpath("//button")).click();
//        find user name box
        WebElement userName = driver.findElement(By.id("username"));
//        wait till it will be visible
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(userName));
//        send user name
        userName.sendKeys(" tomsmith");

        driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        submitButton.click();
    }


    @AfterClass
    public void closure(){
        driver.quit();
    }




}
