package com.example.mobsoft.utazo;

import android.content.Context;

import com.example.mobsoft.utazo.di.Network;
import com.example.mobsoft.utazo.ui.destinations.DestinationsPresenter;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;
import com.example.mobsoft.utazo.utils.UiExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {
    private Context context;

    public TestModule(Context context) { this.context = context; }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public DestinationsPresenter provideDestinationPresenter() {
        return new DestinationsPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor(){
        return new UiExecutor();
    }
}
