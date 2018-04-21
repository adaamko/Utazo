package com.example.mobsoft.utazo.ui.about;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsInteractor;
import com.example.mobsoft.utazo.ui.Presenter;
import com.example.mobsoft.utazo.ui.destinations.DestinationsScreen;

import javax.inject.Inject;

public class AboutPresenter extends Presenter<AboutScreen> {
    @Inject
    DestinationsInteractor destinationsInteractor;

    @Override
    public void attachScreen(AboutScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}

