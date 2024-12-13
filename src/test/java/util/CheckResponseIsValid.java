package util;

import io.restassured.response.Response;
import org.testng.Assert;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CheckResponseIsValid {


    public static void checkResponseIsValid(Response response) {
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getContentType()).isEqualTo("application/json; charset=utf-8");
    }

    public static void checkResponseIsValid(Response response, int expectedStatusCode, String expectedContentType) {

        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Expected status code: " + expectedStatusCode + " but got: " + response.getStatusCode());
        Assert.assertEquals(response.getContentType(), expectedContentType, "Expected content type: " + "application/json; charset=utf-8" + " but got: " + response.getContentType());

        //assert j
        assertThat(response.getStatusCode()).isEqualTo(expectedStatusCode);
        assertThat(response.getContentType()).isEqualTo(expectedContentType);
    }


}
