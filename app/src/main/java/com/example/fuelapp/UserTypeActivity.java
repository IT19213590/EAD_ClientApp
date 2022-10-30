package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        getSupportActionBar().hide();

        Button user_button = (Button) findViewById(R.id.btn_user);
        Button owner_button = (Button) findViewById(R.id.btn_owner);

        owner_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent login = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(login);
            }
        });

        user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(),UserRegistartion.class);
                startActivity(login);
            }
        });
    }
}