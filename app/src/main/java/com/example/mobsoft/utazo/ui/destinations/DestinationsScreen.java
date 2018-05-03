package com.example.mobsoft.utazo.ui.destinations;

import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

public interface DestinationsScreen {
    void showDestinations(List<Destination> destinations);

    void showNetworkError(String errorMsg);

    void addDestination();
}
