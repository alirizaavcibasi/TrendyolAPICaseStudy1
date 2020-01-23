package Cases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import Base.TestBase;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;
import org.testng.annotations.Test;



public class trendyolCase01{
    @Test(priority = 1)
    void getharryPotter()
    {

        //Specify Base URI
        RestAssured.baseURI="http://www.omdbapi.com";
        //Request Object

        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/?apikey=2a3ce4d1&s=Harry+Potter");
        ResponseBody body=response.getBody();
        //Response Object
        System.out.println("Response body is "+body.prettyPrint());

    }

}

