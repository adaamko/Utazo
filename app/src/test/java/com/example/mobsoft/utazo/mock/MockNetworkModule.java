package com.example.mobsoft.utazo.mock;

import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule {

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()));

    }

    @Provides
    @Singleton
    public MockDestinationsApi provideDestinationsApi(Retrofit.Builder retrofitBuilder) {
        return new MockDestinationsApi();
    }

}
