package com.example.mobsoft.utazo.interactor;

import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public DestinationsApiInteractor provideDestinationsApiInteractor() {
        return new DestinationsApiInteractor();
    }

    @Provides
    public DestinationsRepositoryInteractor provideRepositoryInteractor() {
        return new DestinationsRepositoryInteractor();
    }
}
