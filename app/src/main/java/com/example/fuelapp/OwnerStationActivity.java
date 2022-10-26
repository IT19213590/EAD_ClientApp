package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class OwnerStationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_station);

        getSupportActionBar().hide();

        Button button = (Button) findViewById(R.id.btn_reg_station_1);
        LinearLayout button2 = (LinearLayout) findViewById(R.id.card_station);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent sign = new Intent(getApplicationContext(),RegisterStationActivity.class);
                startActivity(sign);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent sign = new Intent(getApplicationContext(),StationDetailsActivity.class);
                startActivity(sign);
            }
        });
    }

}