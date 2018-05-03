package com.example.mobsoft.utazo.ui.details;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mobsoft.utazo.R;
import com.example.mobsoft.utazo.UtazoApplication;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsApiInteractor;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.model.Country;
import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;
    @Inject
    DestinationsApiInteractor destinationsApiInteractor;

    @Inject
    DestinationsRepositoryInteractor destinationsRepositoryInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            }
        });
    }

    @Override
    public void createDestination(String name, String country, String description, boolean checked) {
        Destination destination = new Destination();
        Country countryDes = new Country();

        countryDes.setName(country);
        destination.setName(name);
        destination.setCountry(countryDes);
        destination.setDescription(description);
        Destination.StatusEnum visited = Destination.StatusEnum.NOT_VISITED;

        if(checked)
            visited = Destination.StatusEnum.VISITED;

        destination.setStatus(visited);

        List<Destination> destinationList = destinationsRepositoryInteractor.getDestinations();
        for (Destination item : destinationList){
            destinationsRepositoryInteractor.deleteDestination(item);
        }

    }

    @Override
    public void saveDestination() {

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
