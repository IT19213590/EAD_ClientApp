package com.example.fuelapp.APIInterface;

import com.example.fuelapp.models.User;
import com.example.fuelapp.models.ResponseLogin;
import com.example.fuelapp.models.Login;
import com.example.fuelapp.models.ResponseUser;
import com.example.fuelapp.models.APIClient;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IUserAPI {
    @POST("/api/UserManage/register")
    Call<ResponseUser> CreateUser(@Body User user);

    @POST("/api/UserManage/login")
    Call<ResponseLogin> Login(@Body Login login);
}
