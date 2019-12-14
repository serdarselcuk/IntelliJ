package Tests.test_day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.Set;

public class SelectingOthertab
{
    private WebDriver driver ;

    @BeforeClass
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com");

    }
    @Test(description = "Verify title is still Practice")
    public void test_Switch(){
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(4);

        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong");

    }
    @Test(description = "user is able to see new window")
    public void testTabTitle(){
        String oldWindow = driver.getWindowHandle();
//        Every window has an id in selenium that namd as window handle an to read tha we can used getWindowHandle()
        Set<String>windowHanles =  driver.getWindowHandles();
        for (String each :
                windowHanles) {
            if(!each.equals(oldWindow)){
                driver.switchTo().window(each);
                Assert.assertNotEquals(driver.getTitle(),"Practice", "the tab has not been changed");
            }
            driver.switchTo().window(oldWindow);
        }

    }
    @Test(description = "user is able to see new window")
    public void testOldTabTitle(){
        Assert.assertEquals(driver.getTitle(),"ppractice", "couldn't turn back to main tab");
    }

    @AfterClass
    public void closure(){
        driver.quit();
}

}
