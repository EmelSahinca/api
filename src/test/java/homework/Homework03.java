package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Homework03 extends ReqresBaseUrl {

   /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test

    public void homework03(){
//set the url
spec.pathParams("first","users","second",2);


//send the request and get the response
 Response response= given().spec(spec).when().get("/{first}/{second}");
 response.prettyPrint();

 //assertion

        JsonPath jsonPath=response.jsonPath();

        assertEquals("janet.weaver@reqres.in",jsonPath.getString("data.email"));
        assertEquals("Janet",jsonPath.getString("data.first_name"));
        assertEquals("Weaver",jsonPath.getString("data.last_name"));
        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",jsonPath.getString("support.text"));


    }

}
