package Steps;

import Utils.RestassuredExtensions;
import com.google.gson.JsonObject;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utils.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

import static Utils.RestassuredExtensions.Response;

public class apiSteps extends BaseClass {
    public RestassuredExtensions restassuredExtensions;
    SoftAssert softAssert=null;
    JsonPath jsonPathEvaluator;

    @Before
    public void before(Scenario scenario){
        this.scenario=scenario;
        restassuredExtensions = new RestassuredExtensions();
        softAssert = new SoftAssert();
        //objObservatoryForecast=new ObservatoryForecast(getDriver());
    }

    @When("^I login to the application successfully using \"([^\"]*)\"$")
    public void iLoginToTheApplicationSuccessfullyUsing(String url){
    }

    @Then("^I should be able to see the  history of plans subscribed$")
    public void iShouldBeAbleToSeeTheHistoryOfPlansSubscribed() {
        System.out.println(Response.statusCode());
        scenario.log(String.valueOf(Response.statusCode()));
        softAssert.assertTrue(Response.statusCode() == 400);
        jsonPathEvaluator = Response.body().jsonPath();
        System.out.println(jsonPathEvaluator.get("data.user.lastName").toString());
        scenario.log("Last Name: " + jsonPathEvaluator.get("data.user.lastName").toString());

    }

    @When("^I login to the application \"([^\"]*)\" using \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginToTheApplicationUsingAnd(String endpoint, String emailID, String Password) {
        try{
            HashMap<String, String> body=new HashMap<>();
            body.put("email", emailID);
            body.put("password", Password);
            restassuredExtensions.PostOps(endpoint, body);
            scenario.log("Status code: " + Response.statusCode());
            scenario.log("API Response: " + Response.getBody().prettyPrint());
        }catch(Exception e){
            e.printStackTrace();
            scenario.log("Exception Cause " + e.getCause() + "Exception Message " + e.getMessage());
        }
    }
}
