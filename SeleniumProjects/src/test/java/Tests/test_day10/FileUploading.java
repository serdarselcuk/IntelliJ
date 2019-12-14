package Tests.test_day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FileUploading {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");

    }
    @Test(description = "file upload")
    public void fileUpload(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/home/serdar/Pictures/Screenshot from 2019-10-29 12-13-04.png");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(3);
        String text = driver.findElement(By.xpath("//h3[text()]")).getText();
        Assert.assertEquals(text,"File Uploaded!" );
    }
    @AfterMethod
    public void closure(){
        driver.quit();
    }

}
