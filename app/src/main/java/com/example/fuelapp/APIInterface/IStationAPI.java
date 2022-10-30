package com.example.fuelapp.APIInterface;

import com.example.fuelapp.models.Station;
import com.example.fuelapp.models.StationResponse;
import com.example.fuelapp.models.Stations;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IStationAPI {

    @POST("/api/Station")
    Call<Station> AddStation(@Body Station station);

    @PUT("/api/Station/Iquque/{id}/{quque}")
    Call<Stations> UpdateQueue(@Path("id") String id, @Path("quque") String quque, @Body Stations station );

    @GET("/api/Station/serachStation/{id}")
    Call<StationResponse> GetAStation(@Path("id") int id);
}
