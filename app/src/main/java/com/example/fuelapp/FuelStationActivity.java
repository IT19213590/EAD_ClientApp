package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fuelapp.adapters.StationAdapter;
import com.example.fuelapp.models.Stations;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuelStationActivity extends AppCompatActivity {

    public List<Stations> stationList;
   private StationAdapter stationAdapter;
    private Button view;
   private RecyclerView stationView;
   private SearchView searchView;
   private List<Stations> stationsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_station);
        getSupportActionBar().hide();

        view = findViewById(R.id.view_btn);
        stationView = findViewById(R.id.station_list_view);
        searchView = findViewById(R.id.edit_search);

        searchView.clearFocus();
       // LinearLayout card_station = findViewById(R.id.card_station);

      view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(getApplicationContext(),ServiceActivity.class);
                startActivity(search);
            }
        });

        stationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(getApplicationContext(),ViewFuel.class);
                startActivity(search);
            }
        });


        CallApi callApi = new CallApi() {
            @Override
            public void getList(List<Stations> stationsList) {
                stationsArrayList = new ArrayList<>();
                for(Stations station : stationsList){
                    stationsArrayList.add(station);
                }

                stationAdapter = new StationAdapter(stationsList);
                stationView.setLayoutManager(new LinearLayoutManager(FuelStationActivity.this));
                stationView.setAdapter(stationAdapter);
            }
        };
        callApi.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        System.out.println("Print: "+stationAdapter);



/*
        card_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(getApplicationContext(),ViewFuel.class);
                startActivity(sign);
            }
        });
*/
        //fetchPosts();
    }

   @Override
    public void onStart() {
        super.onStart();
        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }
    }

//    private void fetchPosts(){
//        RetrofitClient.getRetrofitClient().getStations().enqueue(new Callback<List<Stations>>() {
//            @Override
//            public void onResponse(Call<List<Stations>> call, Response<List<Stations>> response) {
//                if(response.isSuccessful() && response.body() == null){
//                    stationsList.addAll(response.body());
//                    stationView.setAdapter(stationAdapter);
//                   // stationAdapter.notifyDataSetChanged();
//
//
//                    postsList.addAll(response.body());
//                    recyclerView.setAdapter(postsAdapter);
//                    //postsAdapter.notifyDataSetChanged();
//                    progressBar.setVisibility(View.GONE);
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Stations>> call, Throwable t) {
//                Toast.makeText(FuelStationActivity.this, "Error: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
//                System.out.println(t.getMessage());
//            }
//        });
//    }
/*
    public void getSearchItem(String searchItem){
        List<Stations> filteredStations = new ArrayList<>();

        for (Stations stations : stationList){
           // if(stations.stationId.)){}
        }

    }
*/

    public void search(String str) {
        List<Stations> mylist = new ArrayList<>();
        for (Stations object : stationsArrayList) {
            Integer searchItem = new Integer(object.getStationId());
            if ( searchItem.toString().toLowerCase().contains(str.toLowerCase())) {
                mylist.add(object);
            }
        }

        StationAdapter searchAdapter = new StationAdapter(mylist);
        stationView.setAdapter(searchAdapter);



        /*stationAdapter = new StationAdapter(mylist);
        stationView.setLayoutManager(new LinearLayoutManager(FuelStationActivity.this));
        stationView.setAdapter(stationAdapter);
        */


    }

}