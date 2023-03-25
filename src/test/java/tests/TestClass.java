package tests;

import Objects.ObservatoryForecast;
import Utils.BaseClass;
import org.testng.annotations.Test;

public class TestClass extends BaseClass {
    ObservatoryForecast objObservatoryForecast;
    String forecastdate;

    @Test
    public void taskATest() throws InterruptedException {
        objObservatoryForecast=new ObservatoryForecast(getDriver());
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
