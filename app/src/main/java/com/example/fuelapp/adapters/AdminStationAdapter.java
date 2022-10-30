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
import com.example.fuelapp.StationDetailsActivity;
import com.example.fuelapp.ViewFuel;
import com.example.fuelapp.models.Stations;

import java.util.List;

public class AdminStationAdapter extends RecyclerView.Adapter<AdminStationAdapter.AdminStationViewHolder> {
    private List<Stations> stationsList;

    public AdminStationAdapter(List<Stations> stationsList) {
        this.stationsList = stationsList;
    }

    @NonNull
    @Override
    public AdminStationAdapter.AdminStationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.admin_list_item,parent,false);
        return new AdminStationAdapter.AdminStationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminStationAdapter.AdminStationViewHolder holder, int position) {
        Stations station = stationsList.get(position);
        holder.stationName.setText(station.stationName);
        holder.petrol_available_state.setText(station.petrol_available_state);
        holder.diesel_available_state.setText(station.diesel_available_state);
        holder.address.setText(station.address);
        holder.stationId.setText(String.valueOf(station.stationId));
        holder.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.change.getContext(), StationDetailsActivity.class);
                intent.putExtra("id", stationsList.get(position).id);
                intent.putExtra("stationName", stationsList.get(position).stationName);
                intent.putExtra("stationId", stationsList.get(position).stationId);
                intent.putExtra("ownerId", stationsList.get(position).ownerId);
                intent.putExtra("prtrol_status", stationsList.get(position).petrol_available_state);
                intent.putExtra("diesel_status", stationsList.get(position).diesel_available_state);
                intent.putExtra("cars_quque_count", stationsList.get(position).cars_quque_count);
                intent.putExtra("bike_quque_count", stationsList.get(position).bike_quque_count);
                intent.putExtra("threewheel_quque_count", stationsList.get(position).threewheel_quque_count);
                intent.putExtra("others_prtrol_quque_count", stationsList.get(position).others_prtrol_quque_count);
                intent.putExtra("bus_quque_count", stationsList.get(position).bus_quque_count);
                intent.putExtra("van_quque_count", stationsList.get(position).van_quque_count);
                intent.putExtra("others_diesel_count", stationsList.get(position).others_diesel_count);
                intent.putExtra("address", stationsList.get(position).address);
                intent.putExtra("fueling_Time_per_vehicle", stationsList.get(position).fueling_Time_per_vehicle);
                intent.putExtra("next_petrol_refill_date", stationsList.get(position).next_petrol_refill_date);
                intent.putExtra("next_diesel_refill_date", stationsList.get(position).next_diesel_refill_date);

                holder.change.getContext().startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AdminStationViewHolder extends RecyclerView.ViewHolder {
        TextView stationName,petrol_available_state,diesel_available_state,address,stationId,cars_quque_count,bike_quque_count,threewheel_quque_count,prtrol_quque_count,bus_quque_count,van_quque_count,fueling_Time_per_vehicle,next_petrol_refill_date,next_diesel_refill_date;
        Button view, change;
        public AdminStationViewHolder(@NonNull View itemView) {
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
            view = (Button) itemView.findViewById(R.id.station_changed);
            //change = (Button) itemView.findViewById(R.id.station_changed);
        }
    }
}
