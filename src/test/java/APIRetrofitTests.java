
import models.Board;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import services.TrelloApiService;
import util.*;
import utils.RetrofitClient;

import static org.assertj.core.api.Assertions.assertThat;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class APIRetrofitTests extends BaseTest{


    @Test(priority = 1)
    public void getBoardRetrofit() {
        try {
            String boardId = "675c119a6dd4e23672cba62c";
            TrelloApiService apiService = RetrofitClient.getRetrofitInstance().create(TrelloApiService.class);

            Call<Board> call = apiService.getBoardR(boardId, API_KEY, API_TOKEN);
            retrofit2.Response<Board> response = call.execute();

            if (response.isSuccessful()) {
                Board board = response.body();
                System.out.println("Board with ID: " + board.getId());

                assertThat(board.getId()).isEqualTo(boardId);
                assertThat(board.getName()).isNotEmpty();
            } else {
                System.out.println("Error getting board: " + response.message());
                Assert.fail("API call failed - response code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Test failed for: " + e.getMessage());
        }
    }



    @Test
    public void createBoardRetrofit() {
        try {
            String name = "My new board";

            TrelloApiService apiService = RetrofitClient.getRetrofitInstance().create(TrelloApiService.class);

            Call<Board> call = apiService.createBoardR(name, API_KEY, API_TOKEN);
            retrofit2.Response<Board> response = call.execute();

            if (response.isSuccessful()) {
                Board createdBoard = response.body();
                System.out.println("Board created with ID: " + createdBoard.getId());
                assertThat(createdBoard.getName()).isEqualTo(name);

            } else {
                System.out.println("Error creating board: " + response.message());
                Assert.fail("API call failed with response code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Test failed for: " + e.getMessage());
        }
    }



    @Test(priority = 2)
    public void updateBoardRetrofit() {
        try {
            String boardId = "675c1b1922aa9a6b46ff75c9";
            String updatedName = "Jaa new name";
            String updatedDesc = "Updated desc";

            TrelloApiService apiService = RetrofitClient.getRetrofitInstance().create(TrelloApiService.class);

            Map<String, String> params = new HashMap<>();
            params.put("name", updatedName);
            params.put("desc", updatedDesc);

            Call<Board> call = apiService.updateBoardR(boardId, params, API_KEY, API_TOKEN);
            retrofit2.Response<Board> response = call.execute();

            if (response.isSuccessful()) {
                Board updatedBoard = response.body();
                System.out.println("Board updated with ID: " + updatedBoard.getId());
                assertThat(updatedBoard.getName()).isEqualTo("nina");
                assertThat(updatedBoard.getDesc()).isEqualTo(updatedDesc);
            } else {
                System.out.println("Error updating board: " + response.message());
                Assert.fail("API call failed with response code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Test failed for: " + e.getMessage());
        }
    }


    @Test(priority = 3)
    public void deleteBoardRetrofit() {
        try {
            String boardId = "675c119a6dd4e23672cba62c";
            TrelloApiService apiService = RetrofitClient.getRetrofitInstance().create(TrelloApiService.class);

            Call<Void> call = apiService.deleteBoardR(boardId, API_KEY, API_TOKEN);
            retrofit2.Response<Void> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println("Board deleted successfully with ID: " + boardId);
                assertThat(response.code()).isEqualTo(200);
            } else {
                System.out.println("Error deleting board: " + response.message());
                Assert.fail("API call failed with response code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Test failed for: " + e.getMessage());
        }
    }


}
