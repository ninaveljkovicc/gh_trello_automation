package util;

import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Board;


public class PrepareActualResponse {

        public static Board prepareActualResponse(Response response) throws Exception {
            String responseBody = response.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseBody, Board.class);
        }


}
