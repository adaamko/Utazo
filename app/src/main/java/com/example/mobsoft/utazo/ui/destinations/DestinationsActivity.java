package com.example.mobsoft.utazo.ui.destinations;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.example.mobsoft.utazo.R;
import com.example.mobsoft.utazo.UtazoApplication;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.ui.main.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;

public class DestinationsActivity extends AppCompatActivity{
    @Inject
    DestinationsPresenter destinationsPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_destinations);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        UtazoApplication.injector.inject(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destinationsPresenter.addDestination();
            }
        });
    }



}
