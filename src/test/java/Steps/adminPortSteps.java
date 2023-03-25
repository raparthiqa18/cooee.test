package Steps;


import Utils.BaseClass;
import Utils.WebUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class adminPortSteps extends BaseClass {
    WebUtils utils;
    SoftAssert softAssert=null;
    public WebDriver driver;
    @Before
    public void setup(Scenario scenario){
        this.scenario=scenario;
        utils=new WebUtils(driver);
        utils.launchBrowser("Chrome");
        softAssert=new SoftAssert();
    }

    @When("login to the admin portal$")
    public void portaluserLoginToTheAdminPortal() throws InterruptedException {
        readProperties();
        try{
            utils.enterUserName(properties.getProperty("username"));
            utils.enterPassword(properties.getProperty("password"));
            utils.clickLogin();
            String loggedinUserName = utils.getLoggedinUserName();
            softAssert.assertEquals(loggedinUserName, "Cooee Admin");
            scenario.log("Logged in successfully using \"" + loggedinUserName + "\"");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Then("^User checks whether the \"([^\"]*)\" user's number of subscriptions matches with the admin portal$")
    public void userChecksWhetherTheUserSNumberOfSubscriptionsMatchesWithTheAdminPortal(String arg0){
    }


    @Given("^I have open the admin portal$")
    public void iHaveOpenTheAdminPortal() {
        try{
            utils.driver.get("https://dollarsimclub.com/cooeeadmin/");
            softAssert.assertTrue(1==1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Then("^Capture the \"([^\"]*)\" user's number of subscriptions$")
    public void captureTheUserSNumberOfSubscriptions(String strEmail) {
       try{
           Thread.sleep(10000);
           utils.driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/app-sidebar/div/div[2]/ul/li[3]/a/span")).click();
           utils.driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys(strEmail);
           System.out.println(utils.driver.findElements(By.xpath("/html/body/app-root/app-full-layout/div/div/div/div/app-user-management/div[2]/div/table/tbody/tr")).size());
           if (utils.driver.findElements(By.xpath("/html/body/app-root/app-full-layout/div/div/div/div/app-user-management/div[2]/div/table/tbody/tr")).size()==0){
               System.out.println("User not found in admin portal");
               scenario.log(strEmail +" User not found in admin portal");
           }else{
               System.out.println("User found in the admin portal");
               scenario.log(strEmail +" User found in the admin portal");
               scenario.isFailed();
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @After
    public void cleanup(){
        utils.releaseResources();
        softAssert.assertAll();
    }

}
