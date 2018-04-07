package com.example.mobsoft.utazo.ui.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobsoft.utazo.R;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen{

    @Inject
    DetailsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    @Override
    public void createDestination() {

    }

    @Override
    public void saveDestination() {

    }
}
