package com.example.fuelapp.models;

public class Stations {
    public String id = "";
    public String stationName = "";
    public String ownerId ="";
    public int stationId = 0;
    public String petrol_available_state = "";
    public String diesel_available_state = "";
    public int cars_quque_count = 0;
    public int bike_quque_count = 0;
    public int threewheel_quque_count = 0;
    public int others_prtrol_quque_count = 0;
    public int bus_quque_count = 0;
    public int van_quque_count = 0;
    public int others_diesel_count = 0;
    public String address = "";
    public int fueling_Time_per_vehicle = 0;
    public String next_petrol_refill_date = "";
    public String next_diesel_refill_date = "";

    public Stations(String id, String stationName, String ownerId, int stationId, String petrol_available_state, String diesel_available_state, int cars_quque_count, int bike_quque_count, int threewheel_quque_count, int others_prtrol_quque_count, int bus_quque_count, int van_quque_count, int others_diesel_count, String address, int fueling_Time_per_vehicle, String next_petrol_refill_date, String next_diesel_refill_date) {
        this.id = id;
        this.stationName = stationName;
        this.ownerId = ownerId;
        this.stationId = stationId;
        this.petrol_available_state = petrol_available_state;
        this.diesel_available_state = diesel_available_state;
        this.cars_quque_count = cars_quque_count;
        this.bike_quque_count = bike_quque_count;
        this.threewheel_quque_count = threewheel_quque_count;
        this.others_prtrol_quque_count = others_prtrol_quque_count;
        this.bus_quque_count = bus_quque_count;
        this.van_quque_count = van_quque_count;
        this.others_diesel_count = others_diesel_count;
        this.address = address;
        this.fueling_Time_per_vehicle = fueling_Time_per_vehicle;
        this.next_petrol_refill_date = next_petrol_refill_date;
        this.next_diesel_refill_date = next_diesel_refill_date;
    }

    public Stations() {
    }

    public int getStationId() {
        return stationId;
    }
}
