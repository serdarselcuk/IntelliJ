package Tests.test_day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class ActionsClassHoverPractice {

    private WebDriver driver;
    @BeforeMethod
    public void startup(){
        driver = BrowserFactory.getDriver( "chrome");
        driver.get("http://practice.cybertekschool.com/hovers");

    }
    @Test(description = "actions")
    public void test1(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement image1 = driver.findElement(By.xpath("//img[1]"));
        action.moveToElement(image1).perform();
        WebElement textOfImage = driver.findElement((By.cssSelector((".figure:nth-of-type(1) h5"))));
        String text = textOfImage.getText();
        Assert.assertEquals(text, "name: user1");

    }@Test
    public void test2(){
        Actions action = new Actions(driver);
        for (int i = 1; i <=3; i++){
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type("+i+")"))).perform();

            String name = driver.findElement(By.cssSelector(".figure:nth-of-type("+i+") h5")).getText();
            System.out.println(name);
        }
    }


    @AfterMethod
    public void closure(){
        driver.close();
    }
}
