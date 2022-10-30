package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fuelapp.APIInterface.IStationAPI;
import com.example.fuelapp.APIInterface.IUserAPI;
import com.example.fuelapp.models.APIClient;
import com.example.fuelapp.models.ResponseLogin;
import com.example.fuelapp.models.Station;
import com.example.fuelapp.models.StationResponse;
import com.example.fuelapp.models.Stations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewFuel extends AppCompatActivity {

    private int newString, cars_quque_count, bike_quque_count, threewheel_quque_count, van_quque_count, other_petrol_v_count, stationId, bus_quque_count, other_diesel_v_count,fueling_Time_per_vehicle;
    private String prtrol_status, next_petrol_refill_date, next_diesel_refill_date,ownerId, id, stationName, diesel_status, address;
    private TextView car_queue_count, next_petrol_date, van_count, bike_count, threewheel_count, other_petrol_count;
    private Button join_car_queue,join_bike_queue,join_van_queue,join_threewheeler_queue,joinother_petrol_join_queue, back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fuel);

        getSupportActionBar().hide();

        car_queue_count = findViewById(R.id.car_count);
        van_count = findViewById(R.id.van_count);
        bike_count = findViewById(R.id.bike_count);
        threewheel_count = findViewById(R.id.threewheel_count);
        other_petrol_count = findViewById(R.id.other_petrol_count);
        next_petrol_date = findViewById(R.id.next_petrol);
        join_car_queue = (Button) findViewById(R.id.join_car);
        join_bike_queue = (Button) findViewById(R.id.join_bike);
        join_van_queue = (Button) findViewById(R.id.join_van);
        join_threewheeler_queue = (Button) findViewById(R.id.join_threewheeler);
        joinother_petrol_join_queue = (Button) findViewById(R.id.other_petrol_join);
        back_btn = (Button) findViewById(R.id.back_btn);

        Intent i = getIntent();
      //  newString= i.getIntExtra("id", 0);

        id= i.getStringExtra("id");
        stationName= i.getStringExtra("stationName");
        stationId= i.getIntExtra("stationId",0);
        ownerId= i.getStringExtra("ownerId");
        prtrol_status= i.getStringExtra("prtrol_status");
        diesel_status= i.getStringExtra("diesel_status");
        cars_quque_count= i.getIntExtra("cars_quque_count",0);
        bike_quque_count= i.getIntExtra("bike_quque_count",0);
        threewheel_quque_count= i.getIntExtra("threewheel_quque_count",0);
        other_petrol_v_count= i.getIntExtra("others_prtrol_quque_count",0);
        bus_quque_count = i.getIntExtra("bus_quque_count",0);
        van_quque_count= i.getIntExtra("van_quque_count",0);
        other_diesel_v_count= i.getIntExtra("others_diesel_count",0);
        address= i.getStringExtra("address");
        fueling_Time_per_vehicle= i.getIntExtra("fueling_Time_per_vehicle",0);
        next_petrol_refill_date= i.getStringExtra("next_petrol_refill_date");
        next_diesel_refill_date= i.getStringExtra("next_diesel_refill_date");



        car_queue_count.setText(String.valueOf(cars_quque_count));
        van_count.setText(String.valueOf(van_quque_count));
        bike_count.setText(String.valueOf(bike_quque_count));
        threewheel_count.setText(String.valueOf(threewheel_quque_count));
        other_petrol_count.setText(String.valueOf(other_petrol_v_count));
        next_petrol_date.setText(String.valueOf(next_petrol_refill_date));

        Stations stations = new Stations(id,stationName,ownerId, stationId, prtrol_status, diesel_status,cars_quque_count,bike_quque_count,threewheel_quque_count,other_petrol_v_count,bus_quque_count,van_quque_count,other_diesel_v_count,address,fueling_Time_per_vehicle,next_petrol_refill_date,next_diesel_refill_date);


        join_car_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IStationAPI istationapi = APIClient.getRetrofit().create(IStationAPI.class);
                Call<Stations> call = istationapi.UpdateQueue(id, "Cars_quque_count", stations);
                call.enqueue(new Callback<Stations>() {
                    @Override
                    public void onResponse(Call<Stations> call, Response<Stations> response) {
                        fetchData();
                    }

                    @Override
                    public void onFailure(Call<Stations> call, Throwable t) {
                        fetchData();
                    }
                });
            }
        });

        join_bike_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IStationAPI istationapi = APIClient.getRetrofit().create(IStationAPI.class);
                Call<Stations> call = istationapi.UpdateQueue(id, "Bike_quque_count", stations);
                call.enqueue(new Callback<Stations>() {
                    @Override
                    public void onResponse(Call<Stations> call, Response<Stations> response) {

                    }

                    @Override
                    public void onFailure(Call<Stations> call, Throwable t) {

                    }
                });
            }
        });

        join_van_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IStationAPI istationapi = APIClient.getRetrofit().create(IStationAPI.class);
                Call<Stations> call = istationapi.UpdateQueue(id, "Van_quque_count", stations);
                call.enqueue(new Callback<Stations>() {
                    @Override
                    public void onResponse(Call<Stations> call, Response<Stations> response) {

                    }

                    @Override
                    public void onFailure(Call<Stations> call, Throwable t) {

                    }
                });
            }
        });

        join_threewheeler_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IStationAPI istationapi = APIClient.getRetrofit().create(IStationAPI.class);
                Call<Stations> call = istationapi.UpdateQueue(id, "Threewheel_quque_count", stations);
                call.enqueue(new Callback<Stations>() {
                    @Override
                    public void onResponse(Call<Stations> call, Response<Stations> response) {

                    }

                    @Override
                    public void onFailure(Call<Stations> call, Throwable t) {

                    }
                });
            }
        });

        joinother_petrol_join_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IStationAPI istationapi = APIClient.getRetrofit().create(IStationAPI.class);
                Call<Stations> call = istationapi.UpdateQueue(id, "Others_prtrol_quque_count", stations);
                call.enqueue(new Callback<Stations>() {
                    @Override
                    public void onResponse(Call<Stations> call, Response<Stations> response) {

                    }

                    @Override
                    public void onFailure(Call<Stations> call, Throwable t) {

                    }
                });
            }
        });



        fetchData();

    }

    public void fetchData(){
        IStationAPI istationapi = APIClient.getRetrofit().create(IStationAPI.class);
        Call<StationResponse> call = istationapi.GetAStation(678);
        call.enqueue(new Callback<StationResponse>() {
            @Override
            public void onResponse(Call<StationResponse> call, Response<StationResponse> response) {
                System.out.println("Res:" +response);
            }

            @Override
            public void onFailure(Call<StationResponse> call, Throwable t) {

            }


        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getApplicationContext(),FuelStationActivity.class);
                startActivity(backIntent);
            }
        });
    }
}