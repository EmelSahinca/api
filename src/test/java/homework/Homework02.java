package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.text.AbstractDocument;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Homework02 extends ReqresBaseUrl {
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */


    @Test
    public void homework02(){

     spec.pathParams("first","users","second",23);


     Response response=given().spec(spec).when().get();
     response.prettyPrint();


        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.getHeader("Server"));
        assertTrue(response.asString().contains(""));



    }

}
