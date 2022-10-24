package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        getSupportActionBar().hide();

        Button button = (Button) findViewById(R.id.user_service_btn);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent login = new Intent(getApplicationContext(),FuelStationActivity.class);
                startActivity(login);
            }
        });
    }
}