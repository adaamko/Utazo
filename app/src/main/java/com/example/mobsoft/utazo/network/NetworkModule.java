package com.example.mobsoft.utazo.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public DestinationsApi provideDestinationsApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(NetworkConfig.ENDPOINT_ADDRESS).build().create(DestinationsApi.class);
    }
}
