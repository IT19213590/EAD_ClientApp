package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterStation2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_station2);

        getSupportActionBar().hide();

        Button button = (Button) findViewById(R.id.btn_next2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent sign = new Intent(getApplicationContext(),RegistrationStation3Activity.class);
                startActivity(sign);
            }
        });
    }
}