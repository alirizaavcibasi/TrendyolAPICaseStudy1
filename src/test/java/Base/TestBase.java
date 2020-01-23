package Base;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.testng.log4testng.Logger;

public class TestBase {
    public RequestSpecification httpRequest;
    public Response response;
    public Logger logger;
    public JsonPath jsonPathEvaluator;
    public ResponseBody body;

    //Buraya sık kullanılan methodların eklenmesi gerekiyor henüz bunu nasıl yapmam gerektiğini bilmiyorum.


}


