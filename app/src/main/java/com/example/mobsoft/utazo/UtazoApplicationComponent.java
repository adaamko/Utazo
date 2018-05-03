package com.example.mobsoft.utazo;

import com.example.mobsoft.utazo.interactor.InteractorModule;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.network.NetworkModule;
import com.example.mobsoft.utazo.repository.RepositoryModule;
import com.example.mobsoft.utazo.ui.UIModule;
import com.example.mobsoft.utazo.ui.about.AboutPresenter;
import com.example.mobsoft.utazo.ui.destinations.DestinationsActivity;
import com.example.mobsoft.utazo.ui.destinations.DestinationsAdapter;
import com.example.mobsoft.utazo.ui.destinations.DestinationsFragment;
import com.example.mobsoft.utazo.ui.destinations.DestinationsPresenter;
import com.example.mobsoft.utazo.ui.details.DetailsActivity;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;
import com.example.mobsoft.utazo.ui.main.MainActivity;
import com.example.mobsoft.utazo.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, NetworkModule.class, RepositoryModule.class})
public interface UtazoApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(DetailsActivity detailsActivity);

    void inject(DestinationsFragment destinationsFragment);

    void inject(DestinationsActivity destinationsActivity);

    void inject(DestinationsPresenter destinationsPresenter);

    void inject(DestinationsApiInteractor destinationsApiInteractor);

    void inject(DestinationsRepositoryInteractor destinationsRepositoryInteractor);

    void inject(DetailsPresenter detailsPresenter);

    void inject(AboutPresenter aboutPresenter);

    void inject(DestinationsAdapter destinationsAdapter);

}
