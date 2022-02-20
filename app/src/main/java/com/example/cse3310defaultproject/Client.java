package com.example.cse3310defaultproject;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static Retrofit getClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.198:8005/ProjectMicroService/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit;
    }
}
