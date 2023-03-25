package Steps;

import Objects.Obj_CooeeMobileAp;
import Objects.ObservatoryForecast;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import Utils.BaseClass;

public class mobileappsteps extends BaseClass {
    private Scenario scenario;
    private Obj_CooeeMobileAp obj_cooeeMobileAp;

    @Before
    public void before() {getDriver();}

    @After
    public void after(){
        teardown();
    }


    @When("User login to the mobile app using the {string} and {string}")
    public void userLoginToTheMobileAppUsingTheAnd(String strEmail, String strPassword) {
        try {
            Thread.sleep(8000);
//            System.out.println(mobdriver.findElementsByXPath("//android.widget.TextView [@text=\"Login\"]").size());
            mobdriver.findElementByXPath("//android.widget.TextView [@text=\"Login\"]").click();
            Thread.sleep(3000);
            System.out.println(mobdriver.findElementsByXPath("//android.widget.TextView [@text=\"Login with Email Address\"]").size());
            mobdriver.findElementByXPath("//android.widget.TextView [@text=\"Login with Email Address\"]").click();
            mobdriver.findElementByXPath("//android.widget.EditText [@text=\"Enter your email address\"]").sendKeys(strEmail);
            mobdriver.findElementByXPath("//android.widget.EditText [@text=\"Enter your password\"]").sendKeys(strPassword);
            mobdriver.findElementByXPath("//android.widget.Button [@text=\"Login\"]").click();
            Thread.sleep(3000);
            mobdriver.findElementByXPath("//android.widget.Button [@text=\"Noted!\"]").click();
            if(mobdriver.findElementsByXPath("//android.widget.LinearLayout [@resource-id=\"com.cooee.dev:id/li_okpermission!\"]").size()>1){
                mobdriver.findElementByXPath("//android.widget.LinearLayout [@resource-id=\"com.cooee.dev:id/li_okpermission!\"]").click();
            }
            mobdriver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout/android.widget.ImageView").click();
            Thread.sleep(2000);
            System.out.println("COOEE ID : " + mobdriver.findElementByXPath("//android.widget.TextView [@resource-id=\"com.cooee.dev:id/tvCooeeId\"]").getText());;
            scenario.log("COOEE ID : " + mobdriver.findElementByXPath("//android.widget.TextView [@resource-id=\"com.cooee.dev:id/tvCooeeId\"]").getText());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
