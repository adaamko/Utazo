package com.example.mobsoft.utazo.ui.about;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.ui.Presenter;

import javax.inject.Inject;

public class AboutPresenter extends Presenter<AboutScreen> {
    @Inject
    DestinationsApiInteractor destinationsApiInteractor;

    @Inject
    DestinationsRepositoryInteractor destinationsRepositoryInteractor;

    @Override
    public void attachScreen(AboutScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}

