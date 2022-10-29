package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.fuelapp.adapters.StationAdapter;
import com.example.fuelapp.models.Stations;

import java.util.ArrayList;
import java.util.List;

public class OwnerStationActivity extends AppCompatActivity {

    private List<Stations> stationsList = new ArrayList<>();
    private StationAdapter stationAdapter;
    private Button view;
    private RecyclerView stationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_station);

        getSupportActionBar().hide();

        Button button = (Button) findViewById(R.id.btn_reg_station_1);
        Intent i = getIntent();

        final String ownerId = i.getStringExtra("id");


        stationView = findViewById(R.id.station_list_view);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent sign = new Intent(getApplicationContext(),RegisterStationActivity.class);
                i.putExtra("ownerid",ownerId);
                Log.e("LoginActivity", "ownerid " +ownerId);
                startActivity(sign);
            }
        });

        CallApi callApi = new CallApi() {
            @Override
            public void getList(List<Stations> stationsList) {
                stationAdapter = new StationAdapter(stationsList);
                stationView.setLayoutManager(new LinearLayoutManager(OwnerStationActivity.this));
                stationView.setAdapter(stationAdapter);
            }
        };
        callApi.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }




    }

