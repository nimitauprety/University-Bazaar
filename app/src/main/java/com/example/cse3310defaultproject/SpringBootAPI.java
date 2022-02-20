package com.example.cse3310defaultproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SpringBootAPI {

    @POST("registerUser")
    Call<String> registerUser(@Body UserInfo userInfo);

    @GET("getUserInfo/{utaId}")
    Call<UserInfo> getUserInfo(@Path("utaId") String utaId);

    @GET("getAllInfo")
    Call<List<UserInfo>> getAllInfo();
}
