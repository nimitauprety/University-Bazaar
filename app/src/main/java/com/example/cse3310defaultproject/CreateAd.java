package com.example.cse3310defaultproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class CreateAd extends AppCompatActivity {
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ad);

        Button button2 = findViewById(R.id.createAduploadButton);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar progressBar = findViewById(R.id.createAdProgress);

                Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        counter ++;
                        progressBar.setProgress(counter);

                        if (counter == 100)
                            t.cancel();
                    }
                };

                t.schedule(tt, 0, 100);
            }
        });

        Button button3 = findViewById(R.id.createAdButton3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateAd.this, Advertisement.class);
                startActivity(i);
            }
        });

    }
}