package util;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendRequest{


    public static Response sendGetRequest(RequestSpecification request){

        return request.log().all().get().then().log().all().extract().response();
    }

    public static Response sendPostRequest(RequestSpecification request){

        return request.log().all().post().then().log().all().extract().response();
    }


    public static Response sendPutRequest(RequestSpecification request){
        return request.log().all().put().then().log().all().extract().response();
    }


    public static Response sendDeleteRequest(RequestSpecification request){

        return request.log().all().delete().then().log().all().extract().response();
    }
}

