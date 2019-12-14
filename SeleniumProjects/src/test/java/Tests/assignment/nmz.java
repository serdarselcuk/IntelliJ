package Tests.assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class nmz {
    public void times(){

    }

public  static void take(){
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(120,30));
    driver.get("https://www.muslimpro.com/");
    List<WebElement> times = driver.findElements(By.xpath("//p[@class='praytime']"));
    List<WebElement> seasons = driver.findElements(By.xpath("//p[@class='prayers']"));

    System.out.println(times.get(0).getText());


}

    public static void main(String[] args) {
        take();
    }


}
