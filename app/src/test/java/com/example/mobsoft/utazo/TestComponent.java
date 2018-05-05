package com.example.mobsoft.utazo;

import com.example.mobsoft.utazo.mock.MockNetworkModule;
import com.example.mobsoft.utazo.interactor.InteractorModule;
import com.example.mobsoft.utazo.mock.MockRepositoryModule;
import com.example.mobsoft.utazo.test.DestinationsTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, MockRepositoryModule.class})
public interface TestComponent extends UtazoApplicationComponent {
    void inject(DestinationsTest destinationsTest);
}
