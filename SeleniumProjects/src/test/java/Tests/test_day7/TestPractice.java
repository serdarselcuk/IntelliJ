package Tests.test_day7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TestPractice {

    @Test
    public void test() {
        WebDriver browser = BrowserFactory.getDriver("chrome");
        browser.get("http://cybertekschool.com");
        String actual = browser.getTitle();
        String expected = "practices";
        browser.quit();
//        to verify the actual and expected results
        Assert.assertEquals(actual, expected);

    }
    @Test
    public void TitleIsVisible()
    {
        WebDriver browser = BrowserFactory.getDriver("firefox");
        browser.get("http://practice.cybertekschool.com/");

        WebElement title = browser.findElement(By.cssSelector(".btn.btn-primary"));

        Assert.assertTrue(title.isDisplayed(),"element is not visible");
    }
}



