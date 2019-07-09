package ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredAssertions {

    @BeforeClass
    private static void setUp(){
        RestAssured.baseURI="https://www.bek.dev.cc";
        RestAssured.basePath="/wp-json/wp/v2/posts";

    }

    @Test
    public void postReq(){

        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("title", "making a post with java code");
        reqMap.put("content", "java code related content");
        reqMap.put("status", "publish");

        RequestSpecification request = given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin")
                .contentType(ContentType.JSON);

        Response response = request.when().body(reqMap).log().all().post();

        response.then().log().all().statusCode(201);


        //token for username, password (20 characters used for authorization)

        //UI automation (verifying all through UI)
        //post 5 posts via java code
        //verify those in UI (post, contains or smth)

        //Make 5 posts via UI
        //And add verification(title, content, put) via API java code

        //post from Postman
        //post from UI
        //post from

        //practice on navigating, retrieving and verifying data from json


    }






}
