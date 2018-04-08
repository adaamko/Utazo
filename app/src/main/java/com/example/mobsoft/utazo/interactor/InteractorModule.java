package com.example.mobsoft.utazo.interactor;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public DestinationsInteractor provideArtistsInteractor() {
        return new DestinationsInteractor();
    }
}
