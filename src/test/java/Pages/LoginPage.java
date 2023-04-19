package Pages;

import Utils.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class LoginPage extends utils {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"mat-input-0\"]")
    @CacheLookup
    private WebElement webElementUsername;

    @FindBy(css = "#mat-input-1")
    @CacheLookup
    private WebElement webElementPassword;

    @FindBy(css = "body > app-root > app-sign-in > div > div > div > div > div > div > div.card > div > div > form > div > div.row > div:nth-child(5) > div > button")
    @CacheLookup
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
//        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(driver, this);
    }


    public void enterUserName(String username){
//        driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(username);
        System.out.println("Username field is available: " + isElementPresent(webElementUsername));
        webElementUsername.sendKeys(username);
    }

    public void enterPassword(String password){
//        driver.findElement(By.cssSelector("#mat-input-1")).sendKeys(password);
        System.out.println("Password field is available: " +isElementPresent(webElementPassword));
        webElementPassword.sendKeys(password);
    }

    public Boolean isLoginPageDisplayed(){
        return isElementPresent(loginBtn);
    }

    public void clickLogin(){
        System.out.println("Login button field is available: " +isElementPresent(webElementUsername));
            loginBtn.click();
//        loginBtn.click();
    }


}
