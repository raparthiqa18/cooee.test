package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebUtils extends BaseClass {
    public WebDriver driver;
    public static Properties prop = null;
    public static String url="";
    public static WebDriverWait wait=null;


    @FindBy(xpath = "//*[@id=\"mat-input-0\"]")
    WebElement webElementUsername;

    @FindBy(css = "#mat-input-1")
    WebElement webElementPassword;

    @FindBy(css = "body > app-root > app-sign-in > div > div > div > div > div > div > div.card > div > div > form > div > div.row > div:nth-child(5) > div > button")
    WebElement loginBtn;

    @FindBy(css = "body > app-root > app-full-layout > div > app-navbar > header > div > nav > div.user-box.dropdown > a > div > p")
    WebElement loggedinUser;


    public WebUtils(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(factory, this);
    }


    public void enterUserName(String username){
        driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(By.cssSelector("#mat-input-1")).sendKeys(password);
//        webElementPassword.sendKeys(password);
    }

    public void clickLogin(){

        try {
            driver.findElement(By.cssSelector("body > app-root > app-sign-in > div > div > div > div > div > div > div.card > div > div > form > div > div.row > div:nth-child(5) > div > button")).click();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        loginBtn.click();
    }

    public String getLoggedinUserName(){
        String s = driver.findElement(By.cssSelector("body > app-root > app-full-layout > div > app-navbar > header > div > nav > div.user-box.dropdown > a > div > p")).getText();
        System.out.println(s);
        return s;
//        return loggedinUser.getText();
    }

    public WebDriver launchBrowser(String browserName)  {
        if (browserName.equalsIgnoreCase("Chrome")){
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Rakesh\\Professional\\Automation\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            //options.addArguments("--headless");
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);//normal, eager, none
//            options.addArguments("user-data-dir=C:\\Users\\USER\\AppData\\Local\\Google\\Chrome\\User Data");
            WebDriverManager.chromedriver().setup();//selenium 4 feature
            driver=new ChromeDriver(options);
            driver.manage().deleteAllCookies(); //delete all cookies
            try {
                Thread.sleep(7000); //wait 7 seconds to clear cookies.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (browserName.equalsIgnoreCase("Firefox")){
            driver=new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("Edge")){
            driver=new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
//        FluentWait fluentWait=new FluentWait(driver);
//        fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class).until(ExpectedConditions.alertIsPresent());

        //ChromeOptions vs DesiredCapabilities
        //https://www.guru99.com/chrome-options-desiredcapabilities.html#:~:text=Summary%3A,name%2C%20browser%20platform%2C%20etc.

        try {
            wait=new WebDriverWait(driver, 20,  20000);
//            prop = new Properties();
//            FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Project.properties");
//            prop.load(fis);
//            url=prop.getProperty("url");
            //System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static boolean isElementPresent(String elementXpath){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            System.out.println("Pass");
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void releaseResources() {
        System.out.println("Releasing resources now.....");
        if (null != driver) {
            driver.close();
            driver.quit(); //CLOSES ALL THE OPEN BROWSER SESSIONS LEAVING OTHER STEP EXECUTIONS INCOMPLETE
        }
    }
}
