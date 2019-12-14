package Tests.VYtrack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestBase {

    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;
    protected String loginTitle;
    protected String environment  ;
    protected String user  ;
    protected String password ;

    @BeforeTest
    public void beforeTest(){

        String date = BrowserUtils.getDate();
        //location of report
        String filePath = System.getProperty(("user.dir"))+"/test-output/"+date+"report.html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter((filePath));
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("Vytrack Test Results");
        extentReports.setSystemInfo("Environment","QA1");
        extentReports.setSystemInfo("OS",System.getProperty("os.name"));

        user = ConfigurationReader.getProperty("userName");
        password = ConfigurationReader.getProperty("password");
        environment = ConfigurationReader.getProperty("url");
    }
    @AfterTest
    public void afterReport(){
        extentReports.flush();
    }
    @BeforeMethod
    public void startup() {
        Driver.get().get(environment);
    }

    @AfterMethod
    public void closure(ITestResult result){

        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try {
            // BrowserUtils.getScreenshot(result.getName()) - returns the location of screenshot that have been taken
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test case was skipped: "+result.getName());
        }

        Driver.close();

    }

    }
