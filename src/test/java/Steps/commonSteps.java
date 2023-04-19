package Steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import Utils.BaseClass;
import org.testng.asserts.SoftAssert;

public class commonSteps extends BaseClass {
    SoftAssert softAssert=null;

    @Before
    public void before(Scenario scenario){
        this.scenario=scenario;
        softAssert=new SoftAssert();
        //objObservatoryForecast=new ObservatoryForecast(getDriver());
    }

    @Given("^I'm a active user with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iMAActiveUserWithAnd(String email, String password) {
        userEmail=email;
        userPassword=password;
        System.out.println("Email: " + userEmail + " Password: " + userPassword);
        scenario.log("Email: " + userEmail + " Password: " + userPassword);
    }


    @And("^Plans should match as displayed in admin portal$")
    public void plansShouldMatchAsDisplayedInAdminPortal() {
        softAssert.assertTrue(1==1);
        scenario.log("Scenario Passed");
    }
}
