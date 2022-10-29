package com.example.fuelapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("data")
    @Expose
    private User data = null;

    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("token")
    @Expose
    private String token;

    public ResponseLogin() {
    }

    public ResponseLogin(Boolean success, User data,String token, String msg) {
        this.success = success;
        this.data = data;
        this.msg = msg;
        this.token = token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
