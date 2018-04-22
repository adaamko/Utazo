package com.example.mobsoft.utazo.ui.destinations;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobsoft.utazo.R;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class DestinationsFragment extends Fragment implements DestinationsScreen{
    @Inject
    DetailsPresenter detailsPresenter;

    public DestinationsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_destinations, container, false);
    }


    @Override
    public void showDestinations(List<Destination> destinations) {

    }

    @Override
    public void showNetworkError(String errorMsg) {

    }

    @Override
    public void AddDestination() {

    }
}
