package com.example.mobsoft.utazo.ui.details;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsInteractor;
import com.example.mobsoft.utazo.ui.Presenter;
import com.example.mobsoft.utazo.ui.destinations.DestinationsScreen;

import javax.inject.Inject;

public class DetailsPresenter extends Presenter<DetailsScreen> {
    @Inject
    DestinationsInteractor destinationsInteractor;
    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void createDestinationDetails(){}
}
