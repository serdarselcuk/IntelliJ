package Tests.VYtrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VYtrackCalendarEvents {
    LoginPage login = new LoginPage();
    private RemoteWebDriver driver;
    private String environment = ConfigurationReader.getProperty("url");
    private String user = ConfigurationReader.getProperty("userName");
    private String password =ConfigurationReader.getProperty("password");
    WebDriverWait wait_e ;
    static List<WebElement> texts;


    @BeforeClass
    public void startup(){
        driver = Driver.get();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(environment);
        wait_e = new WebDriverWait(driver,10);
        login.login(user, password);
        WebElement activities = driver.findElement(By.xpath("//*[contains(text(),'   Activities')]"));

        Actions move1 = new Actions(driver);
        wait_e.until(ExpectedConditions.visibilityOf(activities));
        move1.moveToElement(activities).perform();
        WebElement CalendarEvents = driver.findElement(By.linkText("Calendar Events"));
        CalendarEvents.click();
        WebElement mask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait_e.until(ExpectedConditions.invisibilityOf(mask));

    }

    @AfterClass
    public void closure(){
        driver.quit();
    }

    @Test(description = "Options visibility", priority = 1)
    public void TestCase1() {

        WebElement optionsButton = driver.findElement(By.xpath("//*[contains(text(),'   Options')]"));
        Assert.assertTrue(optionsButton.isDisplayed());
    }

    @Test(description = "Page number correction", priority = 2)
    public void TestCase2(){
        WebElement pageNumber = driver.findElement(By.xpath("//input[@type= 'number']"));

        Assert.assertTrue((pageNumber.getAttribute("value").equals("1")));

    }

    @Test(description = "Total Page Number", priority = 3)
    public void TestCase3() {
        WebElement TotalPageNumber = driver.findElement(By.cssSelector("[data-toggle ='dropdown'][class='btn dropdown-toggle ']"));

        Assert.assertTrue((TotalPageNumber.getText().contains("25")));
    }

    @Test(description = "Number of records", priority = 4)
    public void TestCase4() {

        String records = driver.findElement(By.xpath("//label[contains(text(),'Total')]")).getText();
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));

       int numRec = Integer.parseInt(records.substring(9,11));

        Assert.assertEquals(numRec, rows.size());
    }
    @Test(description = "Is selectAll Button working", priority = 5)
    public void TestCase5() {

        WebElement selectAllButton = driver.findElement(By.cssSelector("button input[type = 'checkbox']"));
        wait_e.until(ExpectedConditions.elementToBeClickable(selectAllButton));
        selectAllButton.click();


        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));

        for(WebElement each: rows){
            Assert.assertTrue(each.isSelected());
        }
    }

    @Test(description = "used to provide data and navigation",priority = 10)
    public void TestNavigate(){
        driver.findElement(By.xpath("//*[text()='Testers Meeting']")).click();
        WebElement mask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait_e.until(ExpectedConditions.invisibilityOf(mask));
        texts = driver.findElements(By.cssSelector(".responsive-block .control-label"));
    }
    @DataProvider(name = "DataProvider")
    public static Object[][]DataProvider(){
        String[] data = {"Title","Testers Meeting"
                ,"Description","This is a a weekly testers meeting"
                ,"Start","Nov 27, 2019, 9:30 PM"
                ,"End","Nov 27, 2019, 10:30 PM"
                ,"All-day Event","No"
                ,"Organizer","Stephan Haley"
                ,"Guests","Tom Smith - Required"
                ,"Recurrence","Weekly every 1 week on Wednesday"
                ,"Call Via Hangout","No"};
        Object[][]result = new Object[18][2]; // I will collect the expected and provided data in this 2D array
        int i = 0;
        for (String each : data){
            result[i][0] = data[i];
            result[i][1] =texts.get(i).getText();
            i++;
        }
        return result;
    }
    @Test(dependsOnMethods = { "TestNavigate" }, description = "Testers Meeting", priority = 6 , dataProvider = "DataProvider")
    public void TestCase6(String expected, String actualized ) {
        Assert.assertEquals(actualized, expected);

    }
}
