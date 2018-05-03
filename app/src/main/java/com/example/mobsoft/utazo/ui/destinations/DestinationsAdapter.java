package com.example.mobsoft.utazo.ui.destinations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobsoft.utazo.R;
import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

public class DestinationsAdapter extends RecyclerView.Adapter<DestinationsAdapter.ViewHolder>{
    private Context context;
    private List<Destination> destinationsList;

    public DestinationsAdapter(Context context, List<Destination> destinationsList) {
        this.context = context;
        this.destinationsList = destinationsList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.destination_card, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Destination destination = destinationsList.get(position);

        holder.tvName.setText(destination.getName());
        holder.tvCountry.setText(destination.getCountry().getName().toString());
        holder.tvDescription.setText(destination.getDescription());
        holder.tvVisited.setChecked(destination.getStatus().equals(Destination.StatusEnum.VISITED));
    }

    @Override
    public int getItemCount() {
        return destinationsList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvCountry;
        public TextView tvDescription;
        public CheckBox tvVisited;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvCountry = (TextView) itemView.findViewById(R.id.tvCountry);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            tvVisited = (CheckBox) itemView.findViewById(R.id.tvVisited);
        }
    }
}
