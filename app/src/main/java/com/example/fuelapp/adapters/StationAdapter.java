package com.example.fuelapp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuelapp.R;
import com.example.fuelapp.ViewFuel;
import com.example.fuelapp.models.Stations;

import java.util.ArrayList;
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
        holder.stationId.setText(String.valueOf(station.stationId));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.view.getContext(), ViewFuel.class);
                intent.putExtra("cars_quque_count", stationsList.get(position).cars_quque_count);
                intent.putExtra("bike_quque_count", stationsList.get(position).bike_quque_count);
                intent.putExtra("threewheel_quque_count", stationsList.get(position).threewheel_quque_count);
                intent.putExtra("prtrol_status", stationsList.get(position).petrol_available_state);

                holder.view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stationsList.size();
    }

    public class StationViewHolder extends RecyclerView.ViewHolder {
        TextView stationName,petrol_available_state,diesel_available_state,address,stationId,cars_quque_count,bike_quque_count,threewheel_quque_count,prtrol_quque_count,bus_quque_count,van_quque_count,fueling_Time_per_vehicle,next_petrol_refill_date,next_diesel_refill_date;
        Button view;
        public StationViewHolder(@NonNull View itemView) {
            super(itemView);
            stationName = itemView.findViewById(R.id.edit_stationName);
            petrol_available_state = itemView.findViewById(R.id.edit_petrol_available_state);
            diesel_available_state = itemView.findViewById(R.id.edit_diesel_available_state);
            address = itemView.findViewById(R.id.edit_address);
            stationId = itemView.findViewById(R.id.edit_stationId);
           /* cars_quque_count = itemView.findViewById(R.id.edit_cars_quque_count);
            bike_quque_count = itemView.findViewById(R.id.edit_bike_quque_count);
            threewheel_quque_count = itemView.findViewById(R.id.edit_threewheel_quque_count);
            prtrol_quque_count = itemView.findViewById(R.id.edit_others_prtrol_quque_count);
            bus_quque_count = itemView.findViewById(R.id.edit_bus_quque_count);
            van_quque_count = itemView.findViewById(R.id.edit_van_quque_count);
            fueling_Time_per_vehicle = itemView.findViewById(R.id.edit_fueling_Time_per_vehicle);
            next_petrol_refill_date = itemView.findViewById(R.id.edit_next_petrol_refill_date);
            next_diesel_refill_date = itemView.findViewById(R.id.edit_next_diesel_refill_date);
            */
            view = (Button) itemView.findViewById(R.id.station_view);
        }
    }
}
