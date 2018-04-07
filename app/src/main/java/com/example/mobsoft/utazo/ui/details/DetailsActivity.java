package com.example.mobsoft.utazo.ui.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobsoft.utazo.R;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen{

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
