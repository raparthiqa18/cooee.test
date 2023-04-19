package Pages;

import Utils.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserDashboardPage extends utils {
    WebDriver driver;

    @FindBy(css = "body > app-root > app-full-layout > div > app-navbar > header > div > nav > div.user-box.dropdown > a > div > p")
    @CacheLookup
    private WebElement loggedinUser;

    @FindBy(xpath = "/html/body/app-root/app-full-layout/div/app-sidebar/div/div[2]/ul/li[3]/a/span")
    @CacheLookup
    public  WebElement searchEmail;

    @FindBy(xpath = "//*[@id=\"mat-input-2\"]")
    @CacheLookup
    public WebElement searchEmailID;

    @FindBy(xpath = "//*[@id=\"mat-input-2\"]")
    @CacheLookup
    public List<WebElement> EmailUsers;

    public UserDashboardPage(WebDriver driver) {
        this.driver = driver;
//        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public String getLoggedinUserName(){
        return loggedinUser.getText();  
    }

    public void clickSearch(){
        System.out.println("Search email field is available: " +isElementPresent(searchEmail));
        searchEmail.click();
    }

    public void enterSearchValue(String strEmail){
        searchEmailID.sendKeys(strEmail);
    }

    public Boolean userSearchResults(){
        Boolean flag = false;
        if (EmailUsers.size()>0) {
            flag =  true;
        }
       return flag;
    }

}
