package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class utils {
    public static WebDriverWait wait=null;
    public static WebDriver driver = null;
    public static Properties properties;

    public static WebDriver launchBrowser(String browserName, WebDriver driver)  {
        try{
            if (browserName.equalsIgnoreCase("Chrome")){
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                //options.addArguments("--headless");
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);//normal, eager, none
                WebDriverManager.chromedriver().setup();//selenium 4 feature
                driver=new ChromeDriver(options);
                driver.manage().deleteAllCookies(); //delete all cookies
                try {
                    Thread.sleep(3000); //wait 7 seconds to clear cookies.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if (browserName.equalsIgnoreCase("Firefox")){
                driver=new FirefoxDriver();
            }else if (browserName.equalsIgnoreCase("Edge")){
                driver=new EdgeDriver();
            }
            driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
            wait=new WebDriverWait(driver, 20);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }


    public static boolean isElementPresent(WebElement webElement){
        try{
//            wait.until(ExpectedConditions.prese(webElement));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            System.out.println("Pass");
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void releaseResources() {
        System.out.println("Releasing resources now.....");
        if (null != driver) {
            driver.close();
            driver.quit(); //CLOSES ALL THE OPEN BROWSER SESSIONS LEAVING OTHER STEP EXECUTIONS INCOMPLETE
        }
    }

    public static Properties readProperties(){
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

}
