package com.example.fuelapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;

public class Station {

    @SerializedName("id")
    @Expose
    private String Id;

    @SerializedName("stationName")
    @Expose
    private String StationName;

    @SerializedName("stationId")
    @Expose
     private int StationId;

    @SerializedName("ownerId")
    @Expose
    private String OwnerId;

    @SerializedName("petrol_available_state")
    @Expose
    private String Petrol_available_state;

    @SerializedName("diesel_available_state")
    @Expose
    private String Diesel_available_state;

    @SerializedName("cars_quque_count")
    @Expose
    private int Cars_quque_count;

    @SerializedName("bike_quque_count")
    @Expose
    private int Bike_quque_count;

    @SerializedName("threewheel_quque_count")
    @Expose
    private  int Threewheel_quque_count;

    @SerializedName("others_prtrol_quque_count")
    @Expose
    private  int Others_prtrol_quque_count;

    @SerializedName("bus_quque_count")
    @Expose
    private int Bus_quque_count;

    @SerializedName("van_quque_count")
    @Expose
    private int Van_quque_count;

    @SerializedName("others_diesel_count")
    @Expose
    private  int Others_diesel_count;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("fueling_Time_per_vehicle")
    @Expose
    private int Fueling_Time_per_vehicle;

    @SerializedName("next_petrol_refill_date")
    @Expose
    private DateFormat Next_petrol_refill_date = null;

    @SerializedName("next_diesel_refill_date")
    @Expose
    private DateFormat Next_diesel_refill_date = null;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public int getStationId() {
        return StationId;
    }

    public void setStationId(int stationId) {
        StationId = stationId;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public String getPetrol_available_state() {
        return Petrol_available_state;
    }

    public void setPetrol_available_state(String petrol_available_state) {
        Petrol_available_state = petrol_available_state;
    }

    public String getDiesel_available_state() {
        return Diesel_available_state;
    }

    public void setDiesel_available_state(String diesel_available_state) {
        Diesel_available_state = diesel_available_state;
    }

    public int getCars_quque_count() {
        return Cars_quque_count;
    }

    public void setCars_quque_count(int cars_quque_count) {
        Cars_quque_count = cars_quque_count;
    }

    public int getBike_quque_count() {
        return Bike_quque_count;
    }

    public void setBike_quque_count(int bike_quque_count) {
        Bike_quque_count = bike_quque_count;
    }

    public int getThreewheel_quque_count() {
        return Threewheel_quque_count;
    }

    public void setThreewheel_quque_count(int threewheel_quque_count) {
        Threewheel_quque_count = threewheel_quque_count;
    }

    public int getOthers_prtrol_quque_count() {
        return Others_prtrol_quque_count;
    }

    public void setOthers_prtrol_quque_count(int others_prtrol_quque_count) {
        Others_prtrol_quque_count = others_prtrol_quque_count;
    }

    public int getBus_quque_count() {
        return Bus_quque_count;
    }

    public void setBus_quque_count(int bus_quque_count) {
        Bus_quque_count = bus_quque_count;
    }

    public int getVan_quque_count() {
        return Van_quque_count;
    }

    public void setVan_quque_count(int van_quque_count) {
        Van_quque_count = van_quque_count;
    }

    public int getOthers_diesel_count() {
        return Others_diesel_count;
    }

    public void setOthers_diesel_count(int others_diesel_count) {
        Others_diesel_count = others_diesel_count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFueling_Time_per_vehicle() {
        return Fueling_Time_per_vehicle;
    }

    public void setFueling_Time_per_vehicle(int fueling_Time_per_vehicle) {
        Fueling_Time_per_vehicle = fueling_Time_per_vehicle;
    }

    public DateFormat getNext_petrol_refill_date() {
        return Next_petrol_refill_date;
    }

    public void setNext_petrol_refill_date(DateFormat next_petrol_refill_date) {
        Next_petrol_refill_date = next_petrol_refill_date;
    }

    public DateFormat getNext_diesel_refill_date() {
        return Next_diesel_refill_date;
    }

    public void setNext_diesel_refill_date(DateFormat next_diesel_refill_date) {
        Next_diesel_refill_date = next_diesel_refill_date;
    }

    public Station(String stationName, int stationId, String ownerId, String petrol_available_state, String diesel_available_state, int cars_quque_count, int bike_quque_count, int threewheel_quque_count, int others_prtrol_quque_count, int bus_quque_count, int van_quque_count, int others_diesel_count, String address, int fueling_Time_per_vehicle, DateFormat next_petrol_refill_date, DateFormat next_diesel_refill_date) {
        StationName = stationName;
        StationId = stationId;
        OwnerId = ownerId;
        Petrol_available_state = petrol_available_state;
        Diesel_available_state = diesel_available_state;
        Cars_quque_count = cars_quque_count;
        Bike_quque_count = bike_quque_count;
        Threewheel_quque_count = threewheel_quque_count;
        Others_prtrol_quque_count = others_prtrol_quque_count;
        Bus_quque_count = bus_quque_count;
        Van_quque_count = van_quque_count;
        Others_diesel_count = others_diesel_count;
        this.address = address;
        Fueling_Time_per_vehicle = fueling_Time_per_vehicle;
        Next_petrol_refill_date = next_petrol_refill_date;
        Next_diesel_refill_date = next_diesel_refill_date;
    }

    public Station(String stationName, int stationId, String ownerId, String petrol_available_state, String diesel_available_state, int cars_quque_count, int bike_quque_count, int threewheel_quque_count, int others_prtrol_quque_count, int bus_quque_count, int van_quque_count, int others_diesel_count, String address, int fueling_Time_per_vehicle) {
        StationName = stationName;
        StationId = stationId;
        OwnerId = ownerId;
        Petrol_available_state = petrol_available_state;
        Diesel_available_state = diesel_available_state;
        Cars_quque_count = cars_quque_count;
        Bike_quque_count = bike_quque_count;
        Threewheel_quque_count = threewheel_quque_count;
        Others_prtrol_quque_count = others_prtrol_quque_count;
        Bus_quque_count = bus_quque_count;
        Van_quque_count = van_quque_count;
        Others_diesel_count = others_diesel_count;
        this.address = address;
        Fueling_Time_per_vehicle = fueling_Time_per_vehicle;
    }
}
