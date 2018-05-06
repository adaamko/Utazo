package com.example.mobsoft.utazo.ui.details;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.ui.Presenter;

import java.util.List;

import javax.inject.Inject;

public class DetailsPresenter extends Presenter<DetailsScreen> {
    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void createDestinationDetails(String name, String country, String description, boolean checked) {
        screen.createDestination(name, country, description, checked);
    }

    public List<Destination> getDestinations() {
        return screen.getDestinations();
    }
}
