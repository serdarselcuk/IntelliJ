package Tests.test_day15;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class ConfigurationTest {

    @Test
    public void test1(){
        String expectedBrowser = "chrome";
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);

        System.out.println("browser: "+ ConfigurationReader.getProperty("browser"));
        System.out.println("url: "+ ConfigurationReader.getProperty("url"));
        System.out.println("username:"+ ConfigurationReader.getProperty("user_name"));
        System.out.println("password: "+ ConfigurationReader.getProperty("password"));

    }
}
