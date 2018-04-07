package com.example.mobsoft.utazo.ui.destinations;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobsoft.utazo.R;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;

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
    public void showDestinations() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void AddDestination() {

    }
}
