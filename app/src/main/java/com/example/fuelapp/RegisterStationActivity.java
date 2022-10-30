package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuelapp.APIInterface.IStationAPI;
import com.example.fuelapp.APIInterface.IUserAPI;
import com.example.fuelapp.models.APIClient;
import com.example.fuelapp.models.Login;
import com.example.fuelapp.models.ResponseLogin;
import com.example.fuelapp.models.Station;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterStationActivity extends AppCompatActivity {

    private TextView SationId;
    private TextView StationName;
    private  TextView StationAddress;
    private  TextView Time_per_vehicle;

    private String ownerId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_station);

        getSupportActionBar().hide();

        Button button = (Button) findViewById(R.id.btn_next1);
        SationId = findViewById(R.id.station_Id);
        StationName = findViewById(R.id.station_name);
        StationAddress = findViewById(R.id.station_address);
        Time_per_vehicle = findViewById(R.id.time_per_vehicle);

        Intent i = getIntent();

        final String ownerId = i.getStringExtra("ownerid");
        this.ownerId = ownerId;

        System.out.println("************ownerid" + ownerId );

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub


//                Intent sign = new Intent(getApplicationContext(),RegisterStation2Activity.class);
//                startActivity(sign);

                onRegister();
            }
        });
    }

    protected void  onRegister() {

        int SationId = Integer.parseInt(this.SationId.getText().toString());
        String StationName = this.StationName.getText().toString();
        String StationAddress = this.StationAddress.getText().toString();
        int Time_per_vehicle = Integer.parseInt(this.Time_per_vehicle.getText().toString());

        Station station = new Station(StationName, SationId, this.ownerId, "Not avaliable", "Not available", 0, 0, 0, 0, 0, 0, 0, StationAddress, Time_per_vehicle);

        IStationAPI istationapi = APIClient.getRetrofit().create(IStationAPI.class);
        Call<Station> call = istationapi.AddStation(station);

        call.enqueue(new Callback<Station>() {
            @Override
            public void onResponse(Call<Station> call, Response<Station> response) {

                Log.e("Response", "Response code : "+ response.code());

                Station stationResponse = response.body();

                if(response.code() == 200){

                    Toast.makeText(RegisterStationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent RegisterStation = new Intent(getApplicationContext(),OwnerStationActivity.class);
                    startActivity(RegisterStation);
                }
                else{
                    Toast.makeText(RegisterStationActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Station> call, Throwable t) {
                Toast.makeText(RegisterStationActivity.this, "Registration API call  Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

}