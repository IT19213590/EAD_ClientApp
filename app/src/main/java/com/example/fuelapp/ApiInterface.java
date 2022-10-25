package com.example.fuelapp;

import com.example.fuelapp.models.Stations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/Station")
    Call<List<Stations>> getStations();
}
