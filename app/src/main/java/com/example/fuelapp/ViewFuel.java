package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ViewFuel extends AppCompatActivity {

    private int newString, cars_quque_count, bike_quque_count, threewheel_quque_count;
    private String prtrol_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fuel);

        getSupportActionBar().hide();

        Bundle extras = getIntent().getExtras();
        newString= extras.getInt("id");
        cars_quque_count= extras.getInt("cars_quque_count");
        bike_quque_count= extras.getInt("bike_quque_count");
        threewheel_quque_count= extras.getInt("threewheel_quque_count");
        prtrol_status= extras.getString("prtrol_status");
        System.out.println("Id: "+newString);
        System.out.println("cars_quque_count: "+cars_quque_count);
        System.out.println("bike_quque_count: "+bike_quque_count);
        System.out.println("threewheel_quque_count: "+threewheel_quque_count);
        System.out.println("prtrol_status: "+prtrol_status);
    }
}