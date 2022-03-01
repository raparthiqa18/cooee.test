package Steps;

import Objects.ObservatoryForecast;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import tests.BaseClass;

public class mobileappsteps extends BaseClass {
    private Scenario scenario;
    private ObservatoryForecast objObservatoryForecast;

    @Before
    public void before(Scenario scenario){
        this.scenario=scenario;
        objObservatoryForecast=new ObservatoryForecast(getDriver());
    }

    @Given("^Application is up and running$")
    public void applicationIsUpAndRunning() {
        try{
            objObservatoryForecast.clickAgreeDisclaimer();
            objObservatoryForecast.clickAgreeDisclaimer();
            objObservatoryForecast.clickbackgroundAccess();
            objObservatoryForecast.clickdeviceLocationAccess();
            objObservatoryForecast.closeversioninfo();
            scenario.write("App launched successfully ");
        }catch(Exception e){
            e.printStackTrace();
            scenario.write("Exception Cause " + e.getCause() + "Exception Message " + e.getMessage());
        }
    }


    @When("NineDay Forecast option is selected")
    public void ninedayForecastOptionIsSelected() {
        try{
            objObservatoryForecast.clickmyObservatoryMenu();
            objObservatoryForecast.scrollDown();
            objObservatoryForecast.clickNineDayForecast("9-Day Forecast");
        }catch(Exception e){
            e.printStackTrace();
            scenario.write("Exception Cause " + e.getCause() + "Exception Message " + e.getMessage());
        }
    }


    @Then("Validate NineDay Forecast is displayed")
    public void validateNineDayForecastIsDisplayed() {
       try{
           if (objObservatoryForecast.validateNineDayForecastisDisplayed()){
               scenario.write("9-Day Forecast is displayed successfully");
           }
       }catch(Exception e){
           e.printStackTrace();
           scenario.write("Exception Cause " + e.getCause() + "Exception Message " + e.getMessage());
       }

    }

    @And("Validate next day forecast is displayed")
    public void validateNextDayForecastIsDisplayed() {
       try{
           scenario.write("Next Date \"" + objObservatoryForecast.validateNextDayForecast(1) + "\"Forecast is displayed successfully");
       }catch(Exception e){
           e.printStackTrace();
           scenario.write("Exception Cause " + e.getCause() + "Exception Message " + e.getMessage());
       }
    }

    @After
    public void after(){
        teardown();
    }


}
