package com.example.mobsoft.utazo.ui.destinations;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobsoft.utazo.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class DestinationsActivityFragment extends Fragment {

    public DestinationsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_destinations, container, false);
    }
}
