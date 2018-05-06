package com.example.mobsoft.utazo.ui.details;

import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

public interface DetailsScreen {
    void createDestination(String name, String country, String description, boolean checked);
    List<Destination> getDestinations();
}
