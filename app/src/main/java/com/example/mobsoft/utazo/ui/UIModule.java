package com.example.mobsoft.utazo.ui;

import android.content.Context;

import com.example.mobsoft.utazo.ui.destinations.DestinationsPresenter;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public DestinationsPresenter provideDestinationsPresenter() {
        return new DestinationsPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }

}
