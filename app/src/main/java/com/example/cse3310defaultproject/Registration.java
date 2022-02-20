package com.example.cse3310defaultproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registration extends AppCompatActivity {
    EditText et_username, et_firstname, et_lastname, et_password, et_cpassword, et_email;
    Button btn_register, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

        //Toolbar toolbar = findViewById(R.id.RegistrationToolBar);
        //setSupportActionBar(toolbar);

        et_username = (EditText)findViewById(R.id.et_username);
        et_firstname = (EditText)findViewById(R.id.et_firstname);
        et_lastname = (EditText)findViewById(R.id.et_lastname);
        et_password = (EditText)findViewById(R.id.et_password);
        et_email = (EditText)findViewById(R.id.et_email);
        et_cpassword = (EditText)findViewById(R.id.et_cpassword);

        btn_register = (Button)findViewById(R.id.btn_register);
        btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String firstname = et_firstname.getText().toString();
                String lastname = et_lastname.getText().toString();
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                String confirm_password = et_cpassword.getText().toString();

                if (username.equals("") || firstname.equals("") || lastname.equals("") || email.equals("") || password.equals("") || confirm_password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirm_password)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                } else {
                    UserInfo userInfo = new UserInfo(username, firstname, lastname, email, password);
                    Operations.registerUser(userInfo, v);

                    et_username.getText().clear();
                    et_firstname.getText().clear();
                    et_lastname.getText().clear();
                    et_email.getText().clear();
                    et_password.getText().clear();
                    et_cpassword.getText().clear();

                    Snackbar snackbar = Snackbar.make(v, "Successfully Registered", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
     }
}