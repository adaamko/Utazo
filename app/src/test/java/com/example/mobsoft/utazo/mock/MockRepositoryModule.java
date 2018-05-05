package com.example.mobsoft.utazo.mock;

import com.example.mobsoft.utazo.repository.Repository;

import javax.inject.Singleton;

import dagger.Provides;

public class MockRepositoryModule {
    @Provides
    @Singleton
    public Repository provideRepository() {
        return new MockRepository();
    }
}
