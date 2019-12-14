package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class LoginPage extends BasePage {

    @FindBy(id = "prependedInput")   // this line will initialize web-element
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[starts-with(text(),'Invalid')]")
    public WebElement invalidation;



    public LoginPage() {
//    this means LoginPageClass
       PageFactory.initElements(Driver.get(),this); //
    }

    public  void login(String userName, String password) {
        waitUntilLoaderMaskDisappear();
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password, Keys.ENTER);
    }



}
