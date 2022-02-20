package com.example.cse3310defaultproject;

import android.app.AppComponentFactory;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Operations {

    public static void registerUser(UserInfo userInfo, View v){
        SpringBootAPI springBootAPI;

        Retrofit retrofit = Client.getClient();
        springBootAPI = retrofit.create(SpringBootAPI.class);

        Call<String> call = springBootAPI.registerUser(userInfo);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String answer = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
