package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fuelapp.adapters.StationAdapter;
import com.example.fuelapp.models.Stations;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuelStationActivity extends AppCompatActivity {

    private List<Stations> stationsList = new ArrayList<>();
   private StationAdapter stationAdapter;
    private Button view;
   private RecyclerView stationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_station);
        getSupportActionBar().hide();

        view = findViewById(R.id.view_btn);
        //stationView = findViewById(R.id.stationView);
        LinearLayout card_station = findViewById(R.id.card_station);

      view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stationView.setAdapter(stationAdapter);
                stationView.setLayoutManager(new LinearLayoutManager(FuelStationActivity.this));

                stationAdapter = new StationAdapter(stationsList);


            }
        });

        CallApi callApi = new CallApi();
        callApi.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);


        card_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(getApplicationContext(),ViewFuel.class);
                startActivity(sign);
            }
        });

        //fetchPosts();
    }
/*
    private void fetchPosts(){
        RetrofitClient.getRetrofitClient().getStations().enqueue(new Callback<List<Stations>>() {
            @Override
            public void onResponse(Call<List<Stations>> call, Response<List<Stations>> response) {
                if(response.isSuccessful() && response.body() == null){
                    stationsList.addAll(response.body());
                    stationView.setAdapter(stationAdapter);
                   // stationAdapter.notifyDataSetChanged();

                    /*
                    postsList.addAll(response.body());
                    recyclerView.setAdapter(postsAdapter);
                    //postsAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);


                }
            }

            @Override
            public void onFailure(Call<List<Stations>> call, Throwable t) {
                Toast.makeText(FuelStationActivity.this, "Error: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });
    }
*/
}