package com.example.cse3310defaultproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {
    public Button button1, button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        button1= (Button) findViewById(R.id.btn2);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(PaymentActivity.this, CreditCardActivity.class);
                startActivity(intent);
            }
        });
        button2= (Button) findViewById(R.id.button);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(PaymentActivity.this, ChequeActivity.class);
                startActivity(intent);
            }
        });
    }
}