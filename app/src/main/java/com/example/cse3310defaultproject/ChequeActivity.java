package com.example.cse3310defaultproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class ChequeActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheque);

        button= (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                openPopUpWindow();
            }
        });
    }

    private void openPopUpWindow(){
        Intent popupwindow = new Intent(ChequeActivity.this, PopupActivity.class);
        startActivity(popupwindow);
    }
}