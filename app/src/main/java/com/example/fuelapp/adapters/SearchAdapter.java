/*package com.example.fuelapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuelapp.R;
import com.example.fuelapp.SearchStationActivity;
import com.example.fuelapp.models.Stations;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.searchHolder> {

    private List<Stations> stationsList;
    Context mcontext;

    public SearchAdapter(Context mcontext, ArrayList<Stations> stationList) {
        this.stationsList = stationList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public SearchAdapter.searchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new searchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.searchHolder holder, int position) {
        Stations station = stationsList.get(position);
        holder.stationName.setText(station.stationName);
        holder.petrol_available_state.setText(station.petrol_available_state);
        holder.diesel_available_state.setText(station.diesel_available_state);
        holder.address.setText(station.address);
        holder.stationId.setText(String.valueOf(station.stationId));
        /*holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.view.getContext(), SearchStationActivity.class);
                intent.putExtra("id", stationsList.get(position).stationId);
                holder.view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class searchHolder extends RecyclerView.ViewHolder {
        TextView stationName,petrol_available_state,diesel_available_state,address,stationId,cars_quque_count,bike_quque_count,threewheel_quque_count,prtrol_quque_count,bus_quque_count,van_quque_count,fueling_Time_per_vehicle,next_petrol_refill_date,next_diesel_refill_date;
        public searchHolder(@NonNull View itemView) {
            super(itemView);
            stationName = itemView.findViewById(R.id.edit_stationName);
            petrol_available_state = itemView.findViewById(R.id.edit_petrol_available_state);
            diesel_available_state = itemView.findViewById(R.id.edit_diesel_available_state);
            address = itemView.findViewById(R.id.edit_address);
            stationId = itemView.findViewById(R.id.edit_stationId);
        }
    }
}
*/