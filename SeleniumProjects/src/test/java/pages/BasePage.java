package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserFactory;
import utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import utilities.BrowserUtils;

//everything that is in common among pages
//can go here
//for example top menu elements don't belong to specific page
//top menu appears on every single page
//so we can keep them here
public class BasePage {

    //@FindBy(css="div[class='loader-mask shown']")
    public WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    public BasePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.get(), this);
    }

    /**
     * While this loading screen present, html code is a not complete
     * Some elements can be missing
     * Also, you won't be able to interact with any elements
     * All actions will be intercepted
     * Waits until loader mask (loading bar, spinning wheel) disappears
     * @return true if loader mask is gone, false if something went wrong
     */
    public boolean waitUntilLoaderMaskDisappear(){


        if(Driver.get().findElements(By.cssSelector("div[class='loader-mask shown']")).size() > 0) {
            loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
            try {
                BrowserUtils.waitForInvisibility(loaderMask, 10);
                return true;
            } catch (NoSuchElementException e) {
                System.out.println("Loader mask not found!");
                System.out.println(e.getMessage());
                return true; // no loader mask, all good, return true
            } catch (WebDriverException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    /**
     * This method stands for navigation in vytrack app
     * provide tab name, for example "Fleet" as a String
     * and module name, for example "Vehicles" as a String as well
     * then based on these values, locators will be created
     * @param moduleName
     * @param subModuleName
     * normalize-space() same line .trim() in java
     */
    public void navigateTo(String moduleName, String subModuleName) {
        String moduleLocator = "//*[normalize-space()='"+moduleName+"' and @class='title title-level-1']";
        String subModuleLocator = "//*[normalize-space()='"+subModuleName+"' and @class='title title-level-2']";

        BrowserUtils.waitForPrecense(By.xpath(moduleLocator),5);

        WebElement module = Driver.get().findElement(By.xpath(moduleLocator));

        BrowserUtils.waitForVisibility(module,5);
        BrowserUtils.waitForClickablility(module,5);
        waitUntilLoaderMaskDisappear();
        module.click(); //once we clicked on module, submodule should be visible

        WebElement subModule = Driver.get().findElement(By.xpath(subModuleLocator));
        BrowserUtils.waitForVisibility(subModule,5);
        subModule.click();

        waitUntilLoaderMaskDisappear();
    }

    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForStaleElement(pageSubTitle,5);
        return pageSubTitle.getText();
    }

    public String getUserName(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }
    public void logOut(){
        BrowserUtils.wait(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }

    public void ToMyUser(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForClickablility(userName, 5).click();
        BrowserUtils.waitForClickablility(myUser, 5).click();
    }

}