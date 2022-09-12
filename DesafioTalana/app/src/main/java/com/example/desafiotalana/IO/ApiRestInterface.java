package com.example.desafiotalana.IO;

import com.example.desafiotalana.IO.RESPONSES.FeedResponse;
import com.example.desafiotalana.IO.RESPONSES.LoginResponse;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiRestInterface {
    @POST("/api/login")
    Call<LoginResponse> loginUser(@Body JsonObject jsonObject) ;

    @GET("/api/feed")
    Call<ArrayList<FeedResponse>>getAllFeeds() ;
}
