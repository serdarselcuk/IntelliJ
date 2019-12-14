package Tests.test_day15;

import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Arrays;
import java.util.Spliterators;

public class LoginTest {
    @Test
    public void testLogin(){
        String url = ConfigurationReader.getProperty("Url");

        Driver.get().get(url);
        BrowserUtils.wait(3);
        Driver.close();
    }


}
