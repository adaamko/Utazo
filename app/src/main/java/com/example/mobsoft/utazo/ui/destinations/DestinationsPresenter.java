package com.example.mobsoft.utazo.ui.destinations;

import com.example.mobsoft.utazo.UtazoApplication;
import com.example.mobsoft.utazo.di.Network;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.interactor.destinations.event.GetDestinationsEvent;
import com.example.mobsoft.utazo.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class DestinationsPresenter extends Presenter<DestinationsScreen> {
    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    DestinationsApiInteractor destinationsApiInteractor;

    @Inject
    DestinationsRepositoryInteractor destinationsRepositoryInteractor;

    @Override
    public void attachScreen(DestinationsScreen screen) {
        super.attachScreen(screen);
        UtazoApplication.injector.inject(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void refreshDestinations(){
        screen.showDestinations(destinationsRepositoryInteractor.getDestinations());
    }

    public void addDestination(){
        screen.addDestination();
    }

    public void showDestinationList(){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                destinationsApiInteractor.getDestinations();
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetDestinationsEvent event){
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.addTopDestinations(event.getDestinations());
            }
        }
    }

}
