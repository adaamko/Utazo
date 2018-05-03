package com.example.mobsoft.utazo.ui.destinations;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobsoft.utazo.R;
import com.example.mobsoft.utazo.UtazoApplication;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.ui.about.AboutActivity;
import com.example.mobsoft.utazo.ui.details.DetailsActivity;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class DestinationsFragment extends Fragment implements DestinationsScreen{
    @Inject
    DestinationsPresenter destinationsPresenter;
    private EditText etDestination;
    private RecyclerView recyclerViewDestinations;
    private SwipeRefreshLayout swipeRefreshLayoutDestinations;
    private TextView tvEmpty;
    private List<Destination> destinationList;
    private DestinationsAdapter destinationsAdapter;

    public DestinationsFragment() {
        UtazoApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        destinationsPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        destinationsPresenter.detachScreen();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destinations, container, false);
        tvEmpty = (TextView) view.findViewById(R.id.tvEmpty);
        recyclerViewDestinations = (RecyclerView) view.findViewById(R.id.recyclerViewDestinations);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewDestinations.setLayoutManager(llm);

        destinationList = new ArrayList<>();
        destinationsAdapter = new DestinationsAdapter(getContext(), destinationList);
        recyclerViewDestinations.setAdapter(destinationsAdapter);

        swipeRefreshLayoutDestinations = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayoutDestinations);

        swipeRefreshLayoutDestinations.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                destinationsPresenter.refreshDestinations();
            }
        });
        return view;
    }


    @Override
    public void showDestinations(List<Destination> destinations) {
        if (swipeRefreshLayoutDestinations != null) {
            swipeRefreshLayoutDestinations.setRefreshing(false);
        }

        destinationList.clear();
        destinationList.addAll(destinations);
        destinationsAdapter.notifyDataSetChanged();

        if (destinationList.isEmpty()) {
            recyclerViewDestinations.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        } else {
            recyclerViewDestinations.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void showNetworkError(String errorMsg) {

    }

    @Override
    public void addDestination() {
        Intent intent = new Intent(getActivity().getApplicationContext(), DetailsActivity.class);
        startActivity(intent);
    }
}
