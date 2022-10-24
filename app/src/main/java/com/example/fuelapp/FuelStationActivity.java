package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fuelapp.adapters.StationAdapter;
import com.example.fuelapp.models.Stations;

import java.util.ArrayList;
import java.util.List;

public class FuelStationActivity extends AppCompatActivity {

    private List<Stations> stationsList = new ArrayList<>();
   // private StationAdapter stationAdapter;
    private Button view;
   // private RecyclerView stationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_station);
        getSupportActionBar().hide();

        view = findViewById(R.id.view_btn);
      //  stationView = findViewById(R.id.stationView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView stationView = findViewById(R.id.stationView);
                StationAdapter stationAdapter = new StationAdapter(stationsList);
                stationView.setAdapter(stationAdapter);
                stationView.setLayoutManager(new LinearLayoutManager(FuelStationActivity.this));
            }
        });

        CallApi callApi = new CallApi();
        callApi.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}