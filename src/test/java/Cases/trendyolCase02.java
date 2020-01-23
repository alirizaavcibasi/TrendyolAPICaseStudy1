package Cases;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.testng.annotations.Test;
import Base.TestBase;

public class trendyolCase02 extends TestBase {


    @Test(priority = 2)
    void CheckimdbID()
    {
        //Specify Base URI
        RestAssured.baseURI="http://www.omdbapi.com";
        //Request Object
        RequestSpecification httpRequest= RestAssured.given();

        //Response Object
        Response response=httpRequest.request(Method.GET,"/?apikey=2a3ce4d1&i=tt0241527");

        String responseBody=response.getBody().asString();
        System.out.println("Response body is "+responseBody);

        JsonPath jsonPathEvaluator=response.jsonPath();
        //Validating imdbID
        String imdbid=jsonPathEvaluator.get("imdbID");
        Assert.assertTrue(imdbid.contains("tt0241527"));
        System.out.println("imdbid is "+imdbid);

        ResponseBody body=response.getBody();

    }
    @Test
    void checkTitle()
    {
        //Specify Base URI
        RestAssured.baseURI="http://www.omdbapi.com";

        //Request Object
        RequestSpecification httpRequest= RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/?apikey=2a3ce4d1&i=tt0241527");

        ResponseBody body=response.getBody();
        //Response Object

        String bodyStringValue=body.prettyPrint();
        Assert.assertTrue(bodyStringValue.contains("Title"));
        JsonPath jsonPathEvaluator=response.jsonPath();
        //Validating Title
        String Title=jsonPathEvaluator.get("Title");
        Assert.assertTrue(Title.contentEquals("Harry Potter and the Sorcerer's Stone"));
        System.out.println("title contains: "+Title);


    }
    @Test
    void CheckYear(){
        //Specify Base URI
        RestAssured.baseURI="http://www.omdbapi.com";
        //Request Object
        RequestSpecification httpRequest= RestAssured.given();

        //Response Object
        Response response=httpRequest.request(Method.GET,"/?apikey=2a3ce4d1&i=tt0241527");
        JsonPath jsonPathEvaluator=response.jsonPath();
        //Validating year
        String year=jsonPathEvaluator.get("Year");
        Assert.assertTrue(year.contains("2001"));
        System.out.println("Year is "+year);
    }

    @Test
    void checkReleaseDate()
    {
        //Specify Base URI
        RestAssured.baseURI="http://www.omdbapi.com";
        RequestSpecification httpRequest= RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/?apikey=2a3ce4d1&i=tt0241527");
        //Request Object

        JsonPath jsonPathEvaluator=response.jsonPath();
        //Response Object

        //Validating release date
        String released=jsonPathEvaluator.get("Released");
        Assert.assertTrue(released.contains("16 Nov 2001"));
        System.out.println("Release date is "+released);
    }
    @Test(priority = 3)
    void checkStatus()
    {
        //Specify Base URI
        RestAssured.baseURI="http://www.omdbapi.com";
        //Request Object
        RequestSpecification httpRequest= RestAssured.given();

        //Response Object
        Response response=httpRequest.request(Method.GET,"/?apikey=2a3ce4d1&i=tt0241527");

        //Validating StatusCode
        int statustcode=response.getStatusCode();
        System.out.println("status code is "+ statustcode);
        Assert.assertEquals(statustcode, 200);

        String statusline1=response.statusLine();
        System.out.println(statusline1);

    }


}

