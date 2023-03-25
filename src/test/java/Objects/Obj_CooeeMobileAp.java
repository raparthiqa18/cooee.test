package Objects;

import Utils.utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Obj_CooeeMobileAp extends utils {
    private AppiumDriver<MobileElement> mobdriver;
    public WebDriverWait wait;

    @iOSXCUITFindBy(id = "hko.MyObservatory_v1_0:id/btn_agree")
    @AndroidFindBy(id = "hko.MyObservatory_v1_0:id/btn_agree")
    WebElement btnAgree;

    @iOSXCUITFindBy(id = "hko.MyObservatory_v1_0:id/btn_agree")
    @AndroidFindBy(id = "hko.MyObservatory_v1_0:id/btn_agree")
    List<MobileElement> btnAgreeElements;

    public Obj_CooeeMobileAp(AppiumDriver<MobileElement> mobdriver) {
        this.mobdriver = mobdriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobdriver), this);
//        wait = new WebDriverWait(driver, 30);
    }

    public void clickAgreeDisclaimer(){
        btnAgree.click();
    }
    public void scrollDown(){
        mobdriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
//        Assert.assertEquals(Ninedayforecastdisplayed, true);
    }


}
