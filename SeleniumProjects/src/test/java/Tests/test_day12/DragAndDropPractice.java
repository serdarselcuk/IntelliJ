package Tests.test_day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class DragAndDropPractice {
        WebDriver driver;
    @Test(description = "Drag And Drop")
    public void Practice(){

        driver = BrowserFactory.getDriver("chrome");
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions Act = new Actions(driver);

        WebElement moon = driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));

        Act.dragAndDrop(moon, earth).perform();
        String result = driver.findElement(By.id("droptarget")).getText();
        Assert.assertEquals(result, "You did great!");

    }
    @AfterMethod
    public void closure(){
        driver.close();
    }

}
