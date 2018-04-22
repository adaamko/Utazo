package com.example.mobsoft.utazo.ui.main;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.ui.Presenter;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    DestinationsApiInteractor destinationsApiInteractor;

    @Inject
    DestinationsRepositoryInteractor destinationsRepositoryInteractor;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
    }


