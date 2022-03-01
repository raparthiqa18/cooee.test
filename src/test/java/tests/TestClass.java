package tests;

import Objects.ObservatoryForecast;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass extends BaseClass{
    ObservatoryForecast objObservatoryForecast;
    String forecastdate;

    @Test
    public void taskATest() throws InterruptedException {
        objObservatoryForecast=new ObservatoryForecast(driver);
        objObservatoryForecast.clickAgreeDisclaimer();
        objObservatoryForecast.clickAgreeDisclaimer();
        objObservatoryForecast.clickbackgroundAccess();
        objObservatoryForecast.clickdeviceLocationAccess();
        objObservatoryForecast.closeversioninfo();
        objObservatoryForecast.clickmyObservatoryMenu();
        objObservatoryForecast.scrollDown();
        objObservatoryForecast.clickNineDayForecast("9-Day Forecast");
        forecastdate= objObservatoryForecast.validateNextDayForecast(1);
        System.out.println(forecastdate);
    }
}
