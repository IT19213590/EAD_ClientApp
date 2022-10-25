package com.example.fuelapp.models;

public class Stations {
    public String stationName = "";
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
    public String fueling_Time_per_vehicle = "";
    public String next_petrol_refill_date = "";
    public String next_diesel_refill_date = "";

    public Stations(String stationName, int stationId, String petrol_available_state, String diesel_available_state, int cars_quque_count, int bike_quque_count, int threewheel_quque_count, int others_prtrol_quque_count, int bus_quque_count, int van_quque_count, int others_diesel_count, String address, String fueling_Time_per_vehicle, String next_petrol_refill_date, String next_diesel_refill_date) {
        this.stationName = stationName;
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

    public String getStationName() {
        return stationName;
    }

    public int getStationId() {
        return stationId;
    }

    public String getPetrol_available_state() {
        return petrol_available_state;
    }

    public String getDiesel_available_state() {
        return diesel_available_state;
    }

    public int getCars_quque_count() {
        return cars_quque_count;
    }

    public int getBike_quque_count() {
        return bike_quque_count;
    }

    public int getThreewheel_quque_count() {
        return threewheel_quque_count;
    }

    public int getOthers_prtrol_quque_count() {
        return others_prtrol_quque_count;
    }

    public int getBus_quque_count() {
        return bus_quque_count;
    }

    public int getVan_quque_count() {
        return van_quque_count;
    }

    public int getOthers_diesel_count() {
        return others_diesel_count;
    }

    public String getAddress() {
        return address;
    }

    public String getFueling_Time_per_vehicle() {
        return fueling_Time_per_vehicle;
    }

    public String getNext_petrol_refill_date() {
        return next_petrol_refill_date;
    }

    public String getNext_diesel_refill_date() {
        return next_diesel_refill_date;
    }
}
