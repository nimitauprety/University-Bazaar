package com.example.cse3310defaultproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Marketplace extends AppCompatActivity {
    Button buybutton, sellbutton, tradebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);

        buybutton = findViewById(R.id.buy_button);
        sellbutton = findViewById(R.id.sell_button);
        tradebutton = findViewById(R.id.trade_button);

        buybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Marketplace.this, Buy.class);
                startActivity(intent);
            }

        });

        sellbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Marketplace.this, Sell.class);
                startActivity(intent);
            }

        });

        tradebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Marketplace.this, Trade.class);
                startActivity(intent);
            }

        });
    }

}