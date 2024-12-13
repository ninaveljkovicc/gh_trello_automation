import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.*;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.HashMap;
import java.util.Map;


public class APITests extends BaseTest {


    @Test(priority = 1)
    public void getBoard() {

        try {

            String boardId = "675c11b5393ae44b33d8b97c";
            String url = BASE_URL + "boards/" + boardId + "?key=" + API_KEY + "&token=" + API_TOKEN;

            RequestSpecification request = BuildRequest.buildGetRequest(url);

            Response response = SendRequest.sendGetRequest(request);


            CheckResponseIsValid.checkResponseIsValid(response, 200, "application/json; charset=utf-8");


            Board actualBoard = PrepareActualResponse.prepareActualResponse(response);
            Board expectedBoard = PrepareExpectedResponse.prepareExpectedResponse("675c11b5393ae44b33d8b97c", "Whole new board1", "new board");
            CheckActualVsExpectedResponses.checkBoardEquality(actualBoard, expectedBoard);



           /* String responseBody = response.getBody().toString();
            Board board = JsonUtil.convertJsonToPojo(responseBody);

            Assert.assertEquals(board.getId(), "qHpvLYBM");
            Assert.assertNotNull(board.getName());
            Assert.assertNotNull(board.getDesc());
            */


        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed" + e.getMessage());
        }

    }

    @Test
    public void createBoard() {

        try {
            Map<String, Object> bodyParameters = new HashMap<String, Object>();
            bodyParameters.put("name", "My new board");
            bodyParameters.put("desc", "I am trying to create a board");
            bodyParameters.put("key", API_KEY);
            bodyParameters.put("token", API_TOKEN);


            String url = BASE_URL + "boards/";


            RequestSpecification request = BuildRequest.buildPostRequest(url, bodyParameters);

            Response response = SendRequest.sendPostRequest(request);

            CheckResponseIsValid.checkResponseIsValid(response, 200, "application/json; charset=utf-8");


            //Board actualBoard = PrepareActualResponse.prepareActualResponse(response);


            String responseBody = response.getBody().asString();
            Board board = JsonUtil.convertJsonToPojo(responseBody);

            //Assert.assertEquals(responseBody, bodyParameters);

            //AssertJ assertion !!!!!!!!!!!!!!!!!!!!!!!
            assertThat(response.getStatusCode()).isEqualTo(200);
            assertThat(board.getName()).isEqualTo("My new board");
            assertThat(board.getDesc()).isEqualTo("I am trying to create a board");


            Assert.assertNotNull(board.getId(), "Board ID should not be null");
            Assert.assertEquals(board.getName(), "My new board");
            Assert.assertEquals(board.getDesc(), "I am trying to create a board");


        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed for: " + e.getMessage());
        }

    }


    @Test(priority = 2)
    public void updateBoard() {

        try {
            Map<String, Object> bodyParameters = new HashMap<String, Object>();
            bodyParameters.put("name", "Whole updated board");
            bodyParameters.put("desc", "Trying to update a board");

            String boardId = "675c11b5393ae44b33d8b97c";
            String url = BASE_URL + "boards/" + boardId + "?key=" + API_KEY + "&token=" + API_TOKEN;


            RequestSpecification request = BuildRequest.buildPutRequest(url, bodyParameters);

            Response response = SendRequest.sendPutRequest(request);

            CheckResponseIsValid.checkResponseIsValid(response, 200, "application/json; charset=utf-8");


            Board actualBoard = PrepareActualResponse.prepareActualResponse(response);

            Board expectedBoard = PrepareExpectedResponse.prepareExpectedResponse("675c11b5393ae44b33d8b97c", "Whole updated board", "Trying to update a board");

            CheckActualVsExpectedResponses.checkBoardEquality(actualBoard, expectedBoard);




            /*String responseBody = response.getBody().toString();
            Board board = JsonUtil.convertJsonToPojo(responseBody);

            Assert.assertEquals(board.getName(), "Updated board");
            Assert.assertEquals(board.getDesc(), "Trying to update a board");
            */

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed" + e.getMessage());
        }

    }


    @Test(priority = 3)
    public void deleteBoard() {

        try {

            String boardId = "675c11b5393ae44b33d8b97c";
            String url = BASE_URL + "boards/" + boardId + "?key=" + API_KEY + "&token=" + API_TOKEN;


            RequestSpecification request = BuildRequest.buildDeleteRequest(url);

            Response response = SendRequest.sendDeleteRequest(request);

            CheckResponseIsValid.checkResponseIsValid(response, 200, "application/json; charset=utf-8");

            System.out.println("Successfully deleted board");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed" + e.getMessage());
        }
    }


}