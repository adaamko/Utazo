package com.example.mobsoft.utazo;

import android.app.Application;

import com.example.mobsoft.utazo.ui.UIModule;
import com.orm.SugarApp;

import dagger.internal.DaggerCollections;

public class UtazoApplication extends SugarApp {
    public static UtazoApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerUtazoApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
