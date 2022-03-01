package Steps;
import Utils.utils;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

        @When("^User performs GET operation for \"([^\"]*)\" and queryparams as \"([^\"]*)\" \"([^\"]*)\"$")
        public void userPerformsGETOperationForAndQueryparamsAs(String url, String dataType, String lang){
            try{
                HashMap<String, String> queryparams=new HashMap<>();
                queryparams.put("dataType", dataType);
                queryparams.put("lang", lang);
                response= RestassuredExtensions.GetOps(url, queryparams);
            }catch(Exception e){
                e.printStackTrace();
                scenario.write("Exception Cause " + e.getCause() + "Exception Message " + e.getMessage());
            }
        }

        @Then("^Response should be successfully returned$")
        public void responseShouldBeSuccessfullyReturned() {
            try{
                assertThat(response.statusCode(), equalTo(200));
                scenario.write("Status Code: " + response.statusCode());
            }catch(Exception e){
                e.printStackTrace();
                scenario.write("Exception Cause " + e.getCause() + "Exception Message " + e.getMessage());
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
              scenario.write("Relative humidity for the day after tomorrow " + dayaftertomorrow + " => " + "Minimum: " + forecastMinrh + "% - Maximum: "+ forecastMaxrh + "%.");
          }catch(Exception e){
              System.out.println("Cause of Exception: " + e.getCause());
              System.out.println("Exception message: " + e.getMessage());
              e.printStackTrace();
              scenario.write(response.getBody().toString());
          }
        }

}
