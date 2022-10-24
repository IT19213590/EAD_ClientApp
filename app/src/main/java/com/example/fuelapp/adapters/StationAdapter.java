package com.example.fuelapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuelapp.R;
import com.example.fuelapp.models.Stations;

import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.StationViewHolder> {

    private List<Stations> stationsList;

    public StationAdapter(List<Stations> stationsList) {
        this.stationsList = stationsList;
    }

    @NonNull
    @Override
    public StationAdapter.StationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item,parent,false);
        return new StationAdapter.StationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StationAdapter.StationViewHolder holder, int position) {
        Stations station = stationsList.get(position);
        holder.stationName.setText(station.stationName);
        holder.petrol_available_state.setText(station.petrol_available_state);
        holder.diesel_available_state.setText(station.diesel_available_state);
        holder.address.setText(station.address);
    }

    @Override
    public int getItemCount() {
        return stationsList.size();
    }

    public class StationViewHolder extends RecyclerView.ViewHolder {
        TextView stationName,petrol_available_state,diesel_available_state,address;
        public StationViewHolder(@NonNull View itemView) {
            super(itemView);
            stationName = itemView.findViewById(R.id.edit_stationName);
            petrol_available_state = itemView.findViewById(R.id.edit_petrol_available_state);
            diesel_available_state = itemView.findViewById(R.id.edit_diesel_available_state);
            address = itemView.findViewById(R.id.edit_address);
        }
    }
}
