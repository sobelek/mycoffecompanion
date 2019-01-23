package api;

import model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface APIService {
    @FormUrlEncoded
    @POST("register")
    Call<Result> createUser(
            @Field("cardId") String cardId,
            @Field("password") String password);


    @FormUrlEncoded
    @POST("login")
    Call<Result> loginUser(
            @Field("cardId") String cardId);

}

