package com.example.cse3310defaultproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        TextView textView = (TextView) findViewById(R.id.TextViewPost);

        SpringBootAPI springBootAPI;

        Retrofit retrofit = Client.getClient();
        springBootAPI = retrofit.create(SpringBootAPI.class);

        Call<List<UserInfo>> call = springBootAPI.getAllInfo();

        call.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(@NotNull Call<List<UserInfo>> call, @NotNull Response<List<UserInfo>> response) {
                List<UserInfo> ListUserInfo = response.body();

                if (!response.isSuccessful()){
                    textView.setText("Code: " + response.code());
                    return;
                }

                for (UserInfo userInfo : ListUserInfo){
                    String content = "";

                    content += "Post: " + userInfo.getPost() + "\n";
                    content += "Posted By: " + userInfo.getFirstName() + " " + userInfo.getLastName() + "\n";
                    content += "User Email: " + userInfo.getEmail() + "\n";
                    content += "\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_bar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Intent i = new Intent(HomeScreen.this, Popup.class);
                i.putExtra("User", getIntent().getStringExtra("Username"));
                i.putExtra("Pass", getIntent().getStringExtra("Username"));
                startActivity(i);
                return true;

            case R.id.logout:
                Intent j = new Intent(HomeScreen.this, MainActivity.class);
                startActivity(j);
                return true;

            case R.id.message:
                Intent k = new Intent(HomeScreen.this, Chat.class);
                startActivity(k);
                return true;

            case R.id.payment:
                Intent l = new Intent(HomeScreen.this, Checkout.class);
                startActivity(l);
                return true;

            case R.id.marketplace:
                Intent m = new Intent(HomeScreen.this, Marketplace.class);
                startActivity(m);
                return true;

            case R.id.club:
                Intent n = new Intent(HomeScreen.this, Clubs.class);
                startActivity(n);
                return true;

            case R.id.advertisement:
                Intent o = new Intent(HomeScreen.this, Advertisement.class);
                startActivity(o);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}