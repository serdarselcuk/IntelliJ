package Tests.VYtrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class LoginTests extends TestBase{

    @Test(description = "verify page title")
    public void Test1(){

        loginTitle = Driver.get().getTitle();

        Assert.assertEquals(loginTitle,"Login");
    }

    @Test(description = "login was successfull")
    public void test2(){

        Assert.assertNotEquals(loginTitle, Driver.get().getTitle());

    }



}
