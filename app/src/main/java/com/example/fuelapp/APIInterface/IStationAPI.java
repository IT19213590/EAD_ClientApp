package com.example.fuelapp.APIInterface;

import com.example.fuelapp.models.ResponseUser;
import com.example.fuelapp.models.Station;
import com.example.fuelapp.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IStationAPI {

    @POST("/api/Station")
    Call<Station> AddStation(@Body Station station);
}
