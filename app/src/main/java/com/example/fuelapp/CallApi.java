package com.example.fuelapp;

import android.os.AsyncTask;

import com.example.fuelapp.models.Stations;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class CallApi extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        try{
            URL url = new URL("http://172.25.112.1:5000/api/Station");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();

            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            System.out.println(result);
            result = stringBuilder.toString();
        }catch (Exception e){}
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try{
            JSONArray jsonArray = new JSONArray(result);

            List<Stations> stationsList = new ArrayList<>();
            for (int i =0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Stations stations = new Stations();
                stations.id = jsonObject.getString("id");
                stations.stationName = jsonObject.getString("stationName");
                stations.stationId = jsonObject.getInt("stationId");
                stations.ownerId = jsonObject.getString("ownerId");
                stations.petrol_available_state = jsonObject.getString("petrol_available_state");
                stations.diesel_available_state = jsonObject.getString("diesel_available_state");
                stations.cars_quque_count = jsonObject.getInt("cars_quque_count");
                stations.bike_quque_count = jsonObject.getInt("bike_quque_count");
                stations.threewheel_quque_count = jsonObject.getInt("threewheel_quque_count");
                stations.others_prtrol_quque_count = jsonObject.getInt("others_prtrol_quque_count");
                stations.bus_quque_count = jsonObject.getInt("bus_quque_count");
                stations.van_quque_count = jsonObject.getInt("van_quque_count");
                stations.others_diesel_count = jsonObject.getInt("others_diesel_count");
                stations.address = jsonObject.getString("address");
                stations.next_petrol_refill_date = jsonObject.getString("next_petrol_refill_date");
                stations.next_diesel_refill_date = jsonObject.getString("next_diesel_refill_date");







                stationsList.add(stations);
            }


            getList(stationsList);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public abstract void getList(List<Stations> stationsList);
}
