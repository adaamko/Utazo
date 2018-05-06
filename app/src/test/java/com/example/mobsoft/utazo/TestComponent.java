package com.example.mobsoft.utazo;

import com.example.mobsoft.utazo.mock.MockNetworkModule;
import com.example.mobsoft.utazo.interactor.InteractorModule;
import com.example.mobsoft.utazo.mock.MockRepository;
import com.example.mobsoft.utazo.mock.MockRepositoryModule;
import com.example.mobsoft.utazo.network.NetworkModule;
import com.example.mobsoft.utazo.repository.RepositoryModule;
import com.example.mobsoft.utazo.test.DestinationsTest;
import com.example.mobsoft.utazo.test.DetailsTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class, InteractorModule.class, MockRepositoryModule.class, NetworkModule.class})
public interface TestComponent extends UtazoApplicationComponent {
    void inject(DestinationsTest destinationsTest);
    void inject(DetailsTest detailsTest);
}
