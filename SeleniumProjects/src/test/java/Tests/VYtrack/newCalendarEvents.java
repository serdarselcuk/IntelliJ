package Tests.VYtrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
public class newCalendarEvents extends TestBase
{
    @Test(description = "Verify page subTitle")
    public void test1(){

        extentTest = extentReports.createTest("Verify that page subtitle is equals to 'All Calendar Events'");

        LoginPage loginPage = new LoginPage(); //login page object

        loginPage.login(user, password);

        loginPage.navigateTo("Activities", "Calendar Events");

        String expectedSubtitle = "All Calendar Events";
        String actualSubTitle = loginPage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle, expectedSubtitle);

        extentTest.pass("Verified that page subtitle 'All Calendar Events' is displayed");

        // some changes after pushing
    }

}
