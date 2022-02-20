package com.example.cse3310defaultproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    Button btn_lregister, btn_llogin;
    EditText et_lusername, et_lpassword;

    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();

            backToast.cancel();

            System.exit(0);
        }
        else{
            backToast = Toast.makeText(getBaseContext(), "Press Back Again to Exit", Toast.LENGTH_LONG);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        et_lusername = (EditText)findViewById(R.id.et_lusername);
        et_lpassword = (EditText)findViewById(R.id.et_lpassword);

        btn_llogin = (Button)findViewById(R.id.btn_llogin);
        btn_lregister = (Button)findViewById(R.id.btn_lregister);

        btn_lregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });

        btn_llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_lusername.getText().toString();
                String password = et_lpassword.getText().toString();

                SpringBootAPI springBootAPI;

                Retrofit retrofit = Client.getClient();
                springBootAPI = retrofit.create(SpringBootAPI.class);

                Call<UserInfo> call = springBootAPI.getUserInfo(username);

                call.enqueue(new Callback<UserInfo>() {
                    @Override
                    public void onResponse(@NotNull Call<UserInfo> call, @NotNull Response<UserInfo> response) {
                        UserInfo userInfo = response.body();

                        if(password.equals(userInfo.getpass())){
                            Snackbar snackbar = Snackbar.make(v, "Login Successful", Snackbar.LENGTH_LONG);
                            snackbar.show();

                            Intent i = new Intent(MainActivity.this, HomeScreen.class);
                            i.putExtra("Username", username);
                            i.putExtra("Password", password);

                            startActivity(i);
                        }
                        else{
                            Snackbar snackbar = Snackbar.make(v, "Login Failed\nInvalid StudentID or Password", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<UserInfo> call, @NotNull Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


    }



}