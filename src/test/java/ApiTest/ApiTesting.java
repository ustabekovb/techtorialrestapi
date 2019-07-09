package ApiTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiTesting {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI="https://www.bek.dev.cc/wp-json";
        RestAssured.basePath="/wp/v2";
    }

    @Test
    public void getRequest(){

        given().relaxedHTTPSValidation().
                get("https://www.bek.dev.cc/wp-json/wp/v2/posts").
                then().log().all().
                statusCode(200)
        .and()
        .body("id", equalTo(10));
    }

    @Test
    public void test3(){

        assertThat(5, equalTo(5));

        assertThat(5, not(equalTo(4)));

        List<Integer>numbers = Arrays.asList(4, 5, 6, 10, 12);

        assertThat(numbers, hasItems(10));

        assertThat(numbers, contains(4, 5, 6, 10, 12));

        assertThat("Techtorial Academy", containsString("Academy"));
    }

    @Test
    public void test4(){

        given().relaxedHTTPSValidation().
                get("https://www.bek.dev.cc/wp-json/wp/v2/posts/14").
                then().log().all().
                statusCode(200)
                .and()
                .body("id", equalTo(14));
    }

    @Test
    public void test5(){

        given().relaxedHTTPSValidation().
                get("https://www.bek.dev.cc/wp-json/wp/v2/posts/{14}", 14).
                then().log().all().
                statusCode(200)
                .and()
                .body("id", equalTo(14));
    }

    @Test
    public void test6(){

        given().relaxedHTTPSValidation().pathParam("id", 14).
                get("/posts").
                then().log().all().
                statusCode(200)
                .and()
                .body("id", equalTo(14));
    }


}
