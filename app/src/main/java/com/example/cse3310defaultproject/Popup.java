package com.example.cse3310defaultproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postpopup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width), (int) (height*.6));

        Button button1 = (Button) findViewById(R.id.PostButton1);
        Button button2 = (Button) findViewById(R.id.PostButton2);
        EditText post = (EditText) findViewById(R.id.EditPost);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Popup.this, HomeScreen.class);
                startActivity(i);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = getIntent().getStringExtra("User");
                String password = getIntent().getStringExtra("Pass");

                SpringBootAPI springBootAPI;

                Retrofit retrofit = Client.getClient();
                springBootAPI = retrofit.create(SpringBootAPI.class);

                Call<UserInfo> call = springBootAPI.getUserInfo(username);

                call.enqueue(new Callback<UserInfo>() {
                    @Override
                    public void onResponse(@NotNull Call<UserInfo> call, @NotNull Response<UserInfo> response) {
                        UserInfo userInfo = response.body();
                        userInfo.setPost(post.getText().toString());

                        Operations.registerUser(userInfo, v);

                        post.getText().clear();
                    }

                    @Override
                    public void onFailure(@NotNull Call<UserInfo> call, @NotNull Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                Intent i = new Intent(Popup.this, HomeScreen.class);
                startActivity(i);
            }
        });

    }
}