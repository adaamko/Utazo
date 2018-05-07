package com.example.mobsoft.utazo.ui.details;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.example.mobsoft.utazo.AnalyticsApplication;
import com.example.mobsoft.utazo.R;
import com.example.mobsoft.utazo.UtazoApplication;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.model.Country;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.ui.about.AboutActivity;
import com.example.mobsoft.utazo.ui.destinations.DestinationsActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.List;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;
    @Inject
    DestinationsApiInteractor destinationsApiInteractor;

    @Inject
    DestinationsRepositoryInteractor destinationsRepositoryInteractor;

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_details);
        UtazoApplication.injector.inject(this);
        Button saveDestination = (Button) findViewById(R.id.saveDestination);
        saveDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvName = ((TextInputEditText) findViewById(R.id.dName)).getText().toString();
                String tvCountry =((TextInputEditText) findViewById(R.id.dCountry)).getText().toString();
                String tvDescription = ((TextInputEditText) findViewById(R.id.dDescription)).getText().toString();
                CheckBox tvVisited = (CheckBox) findViewById(R.id.dVisited);
                boolean checked = tvVisited.isChecked();
                detailsPresenter.createDestinationDetails(tvName, tvCountry, tvDescription, checked);

                Intent intent = new Intent(getApplicationContext(), DestinationsActivity.class);
                startActivity(intent);
            }
        });

        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    public void createDestination(String name, String country, String description, boolean checked) {
        Destination destination = new Destination();

        destination.setName(name);
        destination.setCountry(country);
        destination.setDescription(description);
        Destination.StatusEnum visited = Destination.StatusEnum.NOT_VISITED;

        if(checked)
            visited = Destination.StatusEnum.VISITED;

        destination.setStatus(visited);

        mTracker.setScreenName("Image~" + "DetailsActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        destinationsRepositoryInteractor.createDestination(destination);
    }

    @Override
    public List<Destination> getDestinations() {
        return destinationsRepositoryInteractor.getDestinations();
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }
}
