package Steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import Utils.BaseClass;

public class commonSteps extends BaseClass {

    @Before
    public void before(Scenario scenario){
        this.scenario=scenario;
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

    }
}
