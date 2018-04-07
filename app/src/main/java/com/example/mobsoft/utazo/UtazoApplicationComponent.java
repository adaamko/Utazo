package com.example.mobsoft.utazo;

import com.example.mobsoft.utazo.interactor.InteractorModule;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsInteractor;
import com.example.mobsoft.utazo.ui.UIModule;
import com.example.mobsoft.utazo.ui.destinations.DestinationsFragment;
import com.example.mobsoft.utazo.ui.destinations.DestinationsPresenter;
import com.example.mobsoft.utazo.ui.details.DetailsActivity;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class})
public interface UtazoApplicationComponent {
    void inject(DetailsActivity detailsActivity);

    void inject(DestinationsFragment destinationsFragment);

    void inject(DestinationsPresenter destinationsPresenter);

    void inject(DestinationsInteractor destinationsInteractor);

    void inject(DetailsPresenter detailsPresenter);

}
