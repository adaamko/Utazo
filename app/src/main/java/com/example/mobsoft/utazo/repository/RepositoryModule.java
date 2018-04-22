package com.example.mobsoft.utazo.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Singleton
    @Provides
    public Repository provideRepository() {
        return new RepositoryImpl();
    }
}
