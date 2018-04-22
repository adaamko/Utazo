package com.example.mobsoft.utazo.ui.details;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.ui.Presenter;

import javax.inject.Inject;

public class DetailsPresenter extends Presenter<DetailsScreen> {
    @Inject
    DestinationsApiInteractor destinationsApiInteractor;
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
