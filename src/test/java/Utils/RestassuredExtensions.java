package Utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestassuredExtensions {
    public static RequestSpecification Request;

    //Creates a new request specification
    public static RequestSpecification getRequest() {
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://data.weather.gov.hk");
        requestSpecBuilder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec=requestSpecBuilder.build();
        Request = RestAssured.given().spec(requestSpec);
        return Request;
    }

    //To perform GET operation using the URL & Queryparameters
    public static ResponseOptions<Response> GetOps(String url, Map<String, String> queryParam){
        getRequest().queryParams(queryParam);
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
