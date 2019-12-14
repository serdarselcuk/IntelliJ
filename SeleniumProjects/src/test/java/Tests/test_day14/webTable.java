package Tests.test_day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class webTable {

    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void startUp() {
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://practice.cybertekschool.com/tables");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("table1"))));

    }
    @AfterClass
    public void closure(){
        driver.quit();
    }
    @Test(description = "Print table 1 data")
    public void test1(){

        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }
    @Test(description = "verify that columns of nummber is 6 ")
    public void test2(){
        int actualColumn = driver.findElements(By.xpath("//table[1]//thead//tr//th")).size();
        Assert.assertEquals(actualColumn, 6);
    }

    /*while finding the rows if you use the "tbody" in xpath
    it will give you 4 becouse 1 of rows is in the "thead" part of table
    */
    @Test(description = "verifying of rows number")
    public void test3(){
        int expectedRows = 5;
        int actualizedRows = driver.findElements(By.xpath("//table[1]//tr")).size();
        Assert.assertEquals(actualizedRows,expectedRows);
    }
    // in css use " " and in xpath "//" to get any child
    // in css use > in xpath / to get direct child
//    css selector alternative  ==> table[id='table1'] tbody tr:nth-of-type(2)
//    table[id='table1'] tbody tr:nth-of-type(2) td:nth-of-type(3)
    @Test(description = "print all element in  the 2th row excluding tableheader")
    public void test4() {
        int index = 2;// it 'll decide which row will be written
        List<WebElement> rowTheSeccond = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td"));
        for (WebElement each : rowTheSeccond) {
            System.out.println(each.getText());
        }
    }

    @Test(description = "print element in  the 2th row 3 column")
    public void test5(){
        int row =2;// it 'll decide which row will be written
        int column = 3;
        String cell = driver.findElement(By.cssSelector("table[id='table1'] tbody tr:nth-of-type("+row+") td:nth-of-type("+column+")")).getText();
        System.out.println(" in the "+ row +" th row "+ column + " th column : "+ cell);

    }
    @DataProvider(name = "Content")
    public Object[][] Contend(){

        Object[][] cell = new Object[4][1];

        for  ( int row=1 ; row<5; row++){
            cell[row-1][0] = driver.findElement(By.cssSelector("table[id='table1'] tbody tr:nth-of-type("+row+") td:nth-of-type(3)")).getText();
            System.out.println(cell[row-1][0]);
        }
        return cell;
    }
    @Test(description = "chech if emails contains '@' ", dataProvider = "Content")
    public void test6(String cell){
        Assert.assertTrue(cell.contains("@"));
    }
    @Test(description = "correction that lastnames had sorted after clicking LastName title")
    public void test7(){
        driver.findElement(By.xpath("table[id='table1'] th")).click();
        List<WebElement> Lastnames = driver.findElements(By.xpath
                ("table[id='table1']  tbody tr td:nth-of-type(1)"));
        BrowserUtils.wait(5);


    }
}
