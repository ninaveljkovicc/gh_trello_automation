package util;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import io.restassured.RestAssured;
import util.BaseTest;

public class BuildRequest{



        public static RequestSpecification buildPostRequest(String url, Map<String, Object> bodyParameters) {
            return RestAssured.given()
                    .baseUri(url)
                    .contentType(ContentType.JSON)
                    .body(bodyParameters);
        }


        public static RequestSpecification buildGetRequest(String url) {
            return RestAssured.given()
                    .baseUri(url)
                    .contentType(ContentType.JSON)
                    .params("key", "03f10be01f9db866d0956b73aa0537f5", "token", "ATTA5e8d9cd4a968663f1732e7df55df84625e272151f2bebb3f9ec03597b875598e2D6307CF");
        }


        public static RequestSpecification buildPutRequest(String url, Map<String, Object> bodyParameters){
            return RestAssured.given()
                    .baseUri(url).contentType(ContentType.JSON)
                    .body(bodyParameters)
                    .params("key", "03f10be01f9db866d0956b73aa0537f5", "token", "ATTA5e8d9cd4a968663f1732e7df55df84625e272151f2bebb3f9ec03597b875598e2D6307CF");

        }



        public static RequestSpecification buildDeleteRequest(String url){
            return RestAssured.given()
                    .baseUri(url)
                    .contentType(ContentType.JSON)
                    .params("key", "03f10be01f9db866d0956b73aa0537f5", "token", "ATTA5e8d9cd4a968663f1732e7df55df84625e272151f2bebb3f9ec03597b875598e2D6307CF");

        }

}
