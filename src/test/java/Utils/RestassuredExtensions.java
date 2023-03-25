package Utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.bouncycastle.cert.ocsp.Req;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestassuredExtensions {
    public static RequestSpecification Request;
    public static ResponseOptions Response;

    //Creates a new request specification
    public RestassuredExtensions() {
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://dollarsimclub.com");
        requestSpecBuilder.setPort(8443);
        requestSpecBuilder.setContentType(ContentType.JSON);
        Request=requestSpecBuilder.build();
    }

    //To perform GET operation using the URL
    public static void GetOps(String url) throws URISyntaxException {
        Response = RestAssured.given(Request).get(url);
    }

    //To perform GET operation using the URL & Queryparameters
    public static void GetOps(String url, Map<String, String> queryParam){
        Request.queryParams(queryParam);
        Response = RestAssured.given(Request).get(url);
    }

    //To perform POST operation
    public static void PostOps(String url, Map<String, String> body) throws URISyntaxException {
        Request.body(body);
        Response = RestAssured.given(Request).post(url);
    }
}
