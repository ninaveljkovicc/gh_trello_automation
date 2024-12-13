package services;

import models.Board;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface TrelloApiService {


    @GET("boards/{id}")
    Call<Board> getBoardR(@Path("id") String boardId, @Query("key") String key, @Query("token") String token);

    @POST("boards/")
    Call<Board> createBoardR(@Query("name") String name, @Query("key") String key, @Query("token") String token);

    @PUT("boards/{id}")
    Call<Board> updateBoardR(@Path("id") String boardId, @Body Map<String, String> updatedBoard, @Query("key") String key, @Query("token") String token);

    @DELETE("boards/{id}")
    Call<Void> deleteBoardR(@Path("id") String boardId, @Query("key") String key, @Query("token") String token);

}
