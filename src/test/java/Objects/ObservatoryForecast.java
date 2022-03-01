package Objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.utils;
import org.testng.Assert;

import java.util.List;

public class ObservatoryForecast extends utils {
    private AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    public String nextday;

    @iOSXCUITFindBy(id = "hko.MyObservatory_v1_0:id/btn_agree")
    @AndroidFindBy(id = "hko.MyObservatory_v1_0:id/btn_agree")
    WebElement btnAgree;

    @iOSXCUITFindBy(id = "hko.MyObservatory_v1_0:id/btn_agree")
    @AndroidFindBy(id = "hko.MyObservatory_v1_0:id/btn_agree")
    List<MobileElement> btnAgreeElements;

    @iOSXCUITFindBy(id = "android:id/button1")
    @AndroidFindBy(id = "android:id/button1")
    WebElement backgroundAccess;

    @iOSXCUITFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    @AndroidFindBy(id= "com.android.packageinstaller:id/permission_allow_button")
    WebElement deviceLocationAccess;

    @iOSXCUITFindBy(id = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement myObservatoryMenu;

    @iOSXCUITFindBy(id = "android.widget.TextView")
    @AndroidFindBy(className = "android.widget.TextView")
    List<MobileElement> menu_items;

    @iOSXCUITFindBy(id = "hko.MyObservatory_v1_0:id/backgroundImage")
    @AndroidFindBy(id = "hko.MyObservatory_v1_0:id/backgroundImage")
    List<MobileElement> versioninfo;

    @iOSXCUITFindBy(id = "//android.widget.LinearLayout[@content-desc=\"9-Day Forecast\"]/android.widget.TextView")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"9-Day Forecast\"]/android.widget.TextView")
    WebElement nineDayForecast;


    public ObservatoryForecast(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    public void clickAgreeDisclaimer(){
        btnAgree.click();
    }

    public void clickbackgroundAccess(){
        backgroundAccess.click();
    }

    public void clickdeviceLocationAccess(){deviceLocationAccess.click();}

    public void closeversioninfo() throws InterruptedException {

        while(versioninfo.size()==0) {
            Thread.sleep(1000);
        }
        driver.navigate().back();
    }

    public void clickmyObservatoryMenu(){
        myObservatoryMenu.click();
    }

    public void scrollDown(){
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
    }

    public void clickNineDayForecast(String menuItem){
        for (MobileElement menu_item:menu_items) {
            if (menu_item.getText().equals(menuItem)){
                menu_item.click();
                break;
            }
        }
    }

    public boolean validateNineDayForecastisDisplayed(){
        boolean Ninedayforecastdisplayed=nineDayForecast.isDisplayed();
        Assert.assertEquals(Ninedayforecastdisplayed, true);
        return Ninedayforecastdisplayed;
    }

    public String validateNextDayForecast(long noOfDays){
        nextday=utils.addDate(noOfDays);
        String actualdate=driver.findElementByXPath("//android.widget.TextView[@content-desc=\"" + nextday +"\"]").getText();
        if(actualdate.split(" ")[0].length()!=2){
            actualdate="0"+actualdate.split(" ")[0]+" " + actualdate.split(" ")[1];
        }
        System.out.println(nextday.substring(0, 6));
        Assert.assertEquals(actualdate, nextday.substring(0, 6));
        return actualdate;
    }

}
