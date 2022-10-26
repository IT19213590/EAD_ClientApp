package com.example.fuelapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class User {
    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Email")
    @Expose
    private String Email;

    @SerializedName("Password")
    @Expose
    private String Password;

    @SerializedName("PhoneNo")
    @Expose
    private String PhoneNo;

    @SerializedName("NIC")
    @Expose
    private String NIC;

    @SerializedName("Address")
    @Expose
    private String Address;

    @SerializedName("UserRole")
    @Expose
    private String UserRole;

    @SerializedName("VehicleTypeId")
    @Expose
    private String VehicleTypeId;

    @SerializedName("VehicleNumber")
    @Expose
    private String VehicleNumber;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String userRole) {
        UserRole = userRole;
    }

    public String getVehicleTypeId() {
        return VehicleTypeId;
    }

    public void setVehicleTypeId(String vehicleTypeId) {
        VehicleTypeId = vehicleTypeId;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public User( String name, String email, String password, String phoneNo, String NIC, String address, String userRole) {

        this.name = name;
        Email = email;
        Password = password;
        PhoneNo = phoneNo;
        this.NIC = NIC;
        Address = address;
        UserRole = userRole;
    }

    public User(String name, String email, String password, String phoneNo, String NIC, String address, String userRole, String vehicleTypeId, String vehicleNumber) {

        this.name = name;
        Email = email;
        Password = password;
        PhoneNo = phoneNo;
        this.NIC = NIC;
        Address = address;
        UserRole = userRole;
        VehicleTypeId = vehicleTypeId;
        VehicleNumber = vehicleNumber;
    }

    public User(String id, String name, String email, String password, String phoneNo, String NIC, String address, String userRole, String vehicleTypeId, String vehicleNumber) {
        this.id = id;
        this.name = name;
        Email = email;
        Password = password;
        PhoneNo = phoneNo;
        this.NIC = NIC;
        Address = address;
        UserRole = userRole;
        VehicleTypeId = vehicleTypeId;
        VehicleNumber = vehicleNumber;
    }
}
