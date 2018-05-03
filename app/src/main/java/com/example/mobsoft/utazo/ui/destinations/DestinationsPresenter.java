package com.example.mobsoft.utazo.ui.destinations;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.interactor.destinations.event.GetDestinationsEvent;
import com.example.mobsoft.utazo.ui.Presenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

public class DestinationsPresenter extends Presenter<DestinationsScreen> {
    @Inject
    DestinationsApiInteractor destinationsApiInteractor;

    @Inject
    DestinationsRepositoryInteractor destinationsRepositoryInteractor;

    @Override
    public void attachScreen(DestinationsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void refreshDestinations(){}

    public void addDestination(){
        screen.addDestination();
    }

    public void showDestinationList(){}

    /*
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetDestinationsEvent event){
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showDestinations(event.getDestinations());
            }
        }
    }
    */
}
