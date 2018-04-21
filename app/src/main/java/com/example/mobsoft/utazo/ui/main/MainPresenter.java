package com.example.mobsoft.utazo.ui.main;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsInteractor;
import com.example.mobsoft.utazo.ui.Presenter;
import com.example.mobsoft.utazo.ui.destinations.DestinationsScreen;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    DestinationsInteractor destinationsInteractor;
    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
    }


