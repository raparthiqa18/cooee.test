package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
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
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class BaseClass {
    protected AppiumDriver<MobileElement> driver;
    private String platformName="Android";

    public AppiumDriver<MobileElement> getDriver(){
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (platformName){
                case "Android":
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 5T");
                    capabilities.setCapability(MobileCapabilityType.UDID, "18762318");
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    capabilities.setCapability("appPackage","hko.MyObservatory_v1_0" );
                    capabilities.setCapability("appActivity", "hko.MyObservatory_v1_0.AgreementPage");
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
            driver=new AppiumDriver<MobileElement>(url, capabilities);
        }catch(Exception e){
            System.out.println("Error cause: " + e.getCause());
            System.out.println("Error message: " + e.getMessage());
            e.printStackTrace();
        }
        return driver;
    }

    public void teardown(){
        if (driver!=null){
            driver.quit();
        }

    }

    public static void scrollToId(AppiumDriver<MobileElement> driver, String id) {
        MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().resourceIdMatches(\"" + id + "\"));"));
    }
}
