package Steps;
import Utils.utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import Utils.RestassuredExtensions;
import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class MyStepdefs {
    private static ResponseOptions<Response> response;
    private Scenario scenario;

        @Before
        public void before(Scenario scenario){
            this.scenario=scenario;
        }



        @Then("^Response should be successfully returned$")
        public void responseShouldBeSuccessfullyReturned() {
            try{
                assertThat(response.statusCode(), equalTo(200));
                scenario.log("Status Code: " + response.statusCode());
            }catch(Exception e){
                e.printStackTrace();
                scenario.log("Exception Cause " + e.getCause() + "Exception Message " + e.getMessage());
            }
        }

        @And("^Response should contain Relative Humidity for Day after tomorrow$")
        public void responseShouldContainRelativeHumidityForDayAfterTomorrow() {
          try{
              String dayaftertomorrow=response.getBody().jsonPath().get("weatherForecast[1].forecastDate");
              assertThat(response.getBody().jsonPath().get("weatherForecast.forecastDate"), hasItem(utils.forecastdate(2)));
              assertThat(dayaftertomorrow, equalTo(utils.forecastdate(2)));
              String forecastMinrh=response.getBody().jsonPath().get("weatherForecast[1].forecastMinrh.value").toString();
              String forecastMaxrh= response.getBody().jsonPath().get("weatherForecast[1].forecastMaxrh.value").toString();
              scenario.log("Relative humidity for the day after tomorrow " + dayaftertomorrow + " => " + "Minimum: " + forecastMinrh + "% - Maximum: "+ forecastMaxrh + "%.");
          }catch(Exception e){
              System.out.println("Cause of Exception: " + e.getCause());
              System.out.println("Exception message: " + e.getMessage());
              e.printStackTrace();
              scenario.log(response.getBody().toString());
          }
        }


}
