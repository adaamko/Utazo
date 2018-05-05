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
import com.example.mobsoft.utazo.UtazoApplication;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

import javax.inject.Inject;

public class DestinationsAdapter extends RecyclerView.Adapter<DestinationsAdapter.ViewHolder>{
    private Context context;
    private List<Destination> destinationsList;
    @Inject
    DestinationsRepositoryInteractor destinationsRepositoryInteractor;

    public DestinationsAdapter(Context context, List<Destination> destinationsList) {
        this.context = context;
        this.destinationsList = destinationsList;
        UtazoApplication.injector.inject(this);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.destination_card, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Destination destination = destinationsList.get(position);

        holder.tvName.setText(destination.getName());
        holder.tvCountry.setText(destination.getCountry().toString());
        holder.tvDescription.setText(destination.getDescription());
        holder.tvVisited.setChecked(destination.getStatus().equals(Destination.StatusEnum.VISITED));

        if(position<3){
            holder.tvVisited.setEnabled(false);
        }

        holder.tvVisited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox)v.findViewById(R.id.tvVisited);
                if(checkBox.isChecked())
                    destination.setStatus(Destination.StatusEnum.VISITED);
                else
                    destination.setStatus(Destination.StatusEnum.NOT_VISITED);
                destinationsRepositoryInteractor.updateDestination(destination);
            }
        });
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
