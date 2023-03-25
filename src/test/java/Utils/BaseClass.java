package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BaseClass extends utils{
    protected AppiumDriver<MobileElement> mobdriver;
    private String platformName="Android";
    protected String userEmail="";
    protected String userPassword="";
    protected static ResponseOptions<Response> response;
    protected Scenario scenario;
    protected Properties properties;

    public Properties readProperties(){
        FileReader reader= null;
        try {
            reader = new FileReader(System.getProperty("user.dir") + "/Cooee.properties");
            properties=new Properties();
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public AppiumDriver<MobileElement> getDriver(){
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (platformName){
                case "Android":
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RMX1901");
                    capabilities.setCapability(MobileCapabilityType.UDID, "586075d");
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    capabilities.setCapability("appPackage","com.cooee.dev" );
                    capabilities.setCapability("appActivity", "com.cooee.dev.signin_signup.SplashActivity");
                    capabilities.setCapability("autoGrantPermissions", "true");
                case "iOS"  :
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "");
                    capabilities.setCapability(MobileCapabilityType.UDID, "");
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "");
            }
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
            capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            URL url=new URL("http://127.0.0.1:4723/wd/hub");
            mobdriver=new AppiumDriver<MobileElement>(url, capabilities);
            mobdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }catch(Exception e){
            System.out.println("Error cause: " + e.getCause());
            System.out.println("Error message: " + e.getMessage());
            e.printStackTrace();
        }
        return mobdriver;
    }

    public void teardown(){
        if (mobdriver!=null){
            mobdriver.quit();
        }

    }

    public static void scrollToId(AppiumDriver<MobileElement> mobdriver, String id) {
        MobileElement el = mobdriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().resourceIdMatches(\"" + id + "\"));"));
    }
}
