package Steps;

import Objects.Obj_CooeeMobileAp;
import Pages.mobileAppLoginScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import Utils.BaseClass;
import org.testng.asserts.SoftAssert;

public class mobileappsteps extends BaseClass {
    private Scenario scenario;
    private Obj_CooeeMobileAp obj_cooeeMobileAp;
    SoftAssert softAssert=null;
    public AppiumDriver<MobileElement> mobdriver;
    mobileAppLoginScreen mobileAppLoginScreen;


    @Before
    public void before() {
        this.scenario=scenario;
        softAssert=new SoftAssert();
//        this.mobdriver = super.getDriver();
//        mobileAppLoginScreen = new mobileAppLoginScreen(mobdriver);
    }

    @After
    public void after(){
        teardown();
    }


    @When("User login to the mobile app using the {string} and {string}")
    public void userLoginToTheMobileAppUsingTheAnd(String strEmail, String strPassword) {
        try {
            mobdriver = super.getDriver();
            mobileAppLoginScreen = new mobileAppLoginScreen(mobdriver);
            mobileAppLoginScreen.clickLoginBtn();
            Thread.sleep(3000);
            mobileAppLoginScreen.clickloginWithEmailBtn();
            mobileAppLoginScreen.enterEmailID(strEmail);
            mobileAppLoginScreen.enterPassword(strPassword);
            mobileAppLoginScreen.clickLoginMainBtn();
            mobileAppLoginScreen.clickNotedBtn();
            mobileAppLoginScreen.clickokPermissionBtn();
            mobileAppLoginScreen.clickSettingsBtn();
            Thread.sleep(3000);
            softAssert.assertTrue(mobileAppLoginScreen.readCooeeID()!=null);
            System.out.println("COOEE ID: " + mobileAppLoginScreen.readCooeeID());
            scenario.log("COOEE ID: " + mobileAppLoginScreen.readCooeeID());




////            System.out.println(mobdriver.findElementsByXPath("//android.widget.TextView [@text=\"Login\"]").size());
//            mobdriver.findElementByXPath("//android.widget.TextView [@text=\"Login\"]").click();
//            Thread.sleep(3000);
//            System.out.println(mobdriver.findElementsByXPath("//android.widget.TextView [@text=\"Login with Email Address\"]").size());
//            mobdriver.findElementByXPath("//android.widget.TextView [@text=\"Login with Email Address\"]").click();
//            mobdriver.findElementByXPath("//android.widget.EditText [@text=\"Enter your email address\"]").sendKeys(strEmail);
//            mobdriver.findElementByXPath("//android.widget.EditText [@text=\"Enter your password\"]").sendKeys(strPassword);
//            mobdriver.findElementByXPath("//android.widget.Button [@text=\"Login\"]").click();
////            Thread.sleep(3000);
//            mobdriver.findElementByXPath("//android.widget.Button [@text=\"Noted!\"]").click();
//            if(mobdriver.findElementsByXPath("//android.widget.LinearLayout [@resource-id=\"com.cooee.dev:id/li_okpermission!\"]").size()>1){
//                mobdriver.findElementByXPath("//android.widget.LinearLayout [@resource-id=\"com.cooee.dev:id/li_okpermission!\"]").click();
//            }
//            mobdriver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout/android.widget.ImageView").click();
//            Thread.sleep(2000);
//            System.out.println("COOEE ID : " + mobdriver.findElementByXPath("//android.widget.TextView [@resource-id=\"com.cooee.dev:id/tvCooeeId\"]").getText());;
//            scenario.log("COOEE ID : " + mobdriver.findElementByXPath("//android.widget.TextView [@resource-id=\"com.cooee.dev:id/tvCooeeId\"]").getText());

        } catch (Exception e) {
            e.printStackTrace();
            scenario.log("Failed " + e.getMessage());
        } finally {
            teardown();
        }

    }
}
