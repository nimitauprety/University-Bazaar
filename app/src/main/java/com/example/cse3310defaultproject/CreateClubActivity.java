package com.example.cse3310defaultproject;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateClubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_club);

        EditText NewClubName = (EditText) findViewById(R.id.NewClubName);
        String clubname = NewClubName.getText().toString();

        EditText NewClubDescription = (EditText) findViewById(R.id.NewClubDescription);
        String clubdescription = NewClubDescription.getText().toString();

//        submitcreateclub_button =findViewById(R.id.submitcreateclub_button)
//
//        submitcreateclub_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent (CreateClubActivity.this,JoinClubActivity.class);
//                startActivity(intent);
//            }
//
//        });

    }
}