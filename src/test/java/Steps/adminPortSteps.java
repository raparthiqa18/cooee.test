package Steps;


import Pages.UserDashboardPage;
import Pages.LoginPage;
import Utils.utils;
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

public class adminPortSteps extends utils {
    LoginPage loginPage;
    UserDashboardPage userDashboardPage;
    SoftAssert softAssert=null;
    public WebDriver driver;
    private Scenario scenario;

    @Before
    public void setup(Scenario scenario){
        this.scenario=scenario;
        driver = launchBrowser("Chrome", driver);
        loginPage=new LoginPage(driver);
        userDashboardPage = new UserDashboardPage(driver);
        softAssert=new SoftAssert();
        readProperties();
    }

    @When("login to the admin portal$")
    public void portaluserLoginToTheAdminPortal() {
        try{
            loginPage.enterUserName(properties.getProperty("username"));
            loginPage.enterPassword(properties.getProperty("password"));
            loginPage.clickLogin();
            String loggedinUserName = userDashboardPage.getLoggedinUserName();
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
            driver.get("https://dollarsimclub.com/cooeeadmin/");
            softAssert.assertTrue(loginPage.isLoginPageDisplayed());
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Then("^Capture the \"([^\"]*)\" user's number of subscriptions$")
    public void captureTheUserSNumberOfSubscriptions(String strEmail) {
       try{
           userDashboardPage.searchEmail.click();
           userDashboardPage.searchEmailID.sendKeys(strEmail);
           softAssert.assertTrue(userDashboardPage.userSearchResults());
           if(userDashboardPage.userSearchResults()){
                System.out.println("User found in the admin portal");
                scenario.log(strEmail +" User found in the admin portal");
           }else{
                System.out.println("User not found in admin portal");
                scenario.log(strEmail +" User not found in admin portal");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @After
    public void cleanup(){
        loginPage.releaseResources();
        softAssert.assertAll();
    }

}
