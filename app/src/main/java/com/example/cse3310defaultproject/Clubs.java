package com.example.cse3310defaultproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Clubs extends AppCompatActivity {

    Button joinclub_button, myclubs_button, createclub_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        joinclub_button = findViewById(R.id.joinclub_button);
        myclubs_button = findViewById(R.id.myclubs_button);
        createclub_button = findViewById(R.id.createclub_button);

        joinclub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Clubs.this,JoinClubActivity.class);
                startActivity(intent);
            }

        });

        myclubs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Clubs.this,MyClubsActivity.class);
                startActivity(intent);
            }

        });

        createclub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Clubs.this,CreateClubActivity.class);
                startActivity(intent);
            }

        });
    }
}