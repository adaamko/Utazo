package com.example.mobsoft.utazo;

import com.example.mobsoft.utazo.ui.UIModule;
import com.example.mobsoft.utazo.ui.destinations.DestinationsFragment;
import com.example.mobsoft.utazo.ui.details.DetailsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface UtazoApplicationComponent {
    void inject(DetailsActivity detailsActivity);

    void inject(DestinationsFragment destinationsFragment);

}
