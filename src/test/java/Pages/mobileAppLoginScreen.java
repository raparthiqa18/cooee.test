package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class mobileAppLoginScreen {
    public static AppiumDriver<MobileElement> mobdriver;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView [@text=\"Login\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView [@text=\"Login\"]")
    @CacheLookup
    private MobileElement loginBtn;

    @iOSXCUITFindBy(xpath = "//android.widget.Button [@text=\"Login\"]")
    @AndroidFindBy(xpath = "//android.widget.Button [@text=\"Login\"]")
    @CacheLookup
    private MobileElement loginMainBtn;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView [@text=\"Login with Email Address\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView [@text=\"Login with Email Address\"]")
    @CacheLookup
    private MobileElement loginWithEmailBtn;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView [@text=\"Enter your email address\"]\"")
    @AndroidFindBy(xpath = "//android.widget.TextView [@text=\"Enter your email address\"]\"")
    @CacheLookup
    private MobileElement emailIDTextBox;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView [@text=\"Enter your password\"]\"")
    @AndroidFindBy(xpath = "//android.widget.TextView [@text=\"Enter your password\"]\"")
    @CacheLookup
    private MobileElement passwordTextBox;

    @iOSXCUITFindBy(xpath = "//android.widget.Button [@text=\"Noted!\"]")
    @AndroidFindBy(xpath = "//android.widget.Button [@text=\"Noted!\"]")
    @CacheLookup
    private MobileElement notedBtn;

    @iOSXCUITFindBy(xpath = "//android.widget.LinearLayout [@resource-id=\"com.cooee.dev:id/li_okpermission!\"]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout [@resource-id=\"com.cooee.dev:id/li_okpermission!\"]")
    @CacheLookup
    private MobileElement okpermissionBtn;

    @iOSXCUITFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout/android.widget.ImageView")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout/android.widget.ImageView")
    @CacheLookup
    private MobileElement settingsBtn;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView [@resource-id=\"com.cooee.dev:id/tvCooeeId\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView [@resource-id=\"com.cooee.dev:id/tvCooeeId\"]")
    @CacheLookup
    private MobileElement cooeeIdLabel;

    public mobileAppLoginScreen(AppiumDriver<MobileElement> mobdriver) {
        this.mobdriver = mobdriver;
//        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(mobdriver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(mobdriver), this);
    }

    public void clickLoginBtn(){
        clickButton(loginBtn);
    }

    public void clickLoginMainBtn(){
        clickButton(loginMainBtn);
    }


    public void clickloginWithEmailBtn(){
        clickButton(loginWithEmailBtn);
    }

    public void clickNotedBtn(){
        clickButton(notedBtn);
    }

    public void clickokPermissionBtn(){
        clickButton(okpermissionBtn);
        clickButton(okpermissionBtn);
    }

    public void clickSettingsBtn(){
        clickButton(settingsBtn);
    }

    public void enterEmailID(String strEmail){
        emailIDTextBox.sendKeys(strEmail);
    }


    public void enterPassword(String strPassword){
        passwordTextBox.sendKeys(strPassword);
    }

    public String readCooeeID(){
       return cooeeIdLabel.getText();
    }

    public static void clickButton(MobileElement element){
        try{
            if(element.isDisplayed()){
                element.click();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
