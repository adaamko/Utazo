package com.example.mobsoft.utazo.ui.destinations;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsInteractor;
import com.example.mobsoft.utazo.ui.Presenter;

import javax.inject.Inject;

public class DestinationsPresenter extends Presenter<DestinationsScreen> {
    @Inject
    DestinationsInteractor destinationsInteractor;
    @Override
    public void attachScreen(DestinationsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void refreshDestinations(){}

    public void addDestination(){}

    public void showDestinationList(){}
}
