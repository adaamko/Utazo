package com.example.mobsoft.utazo.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobsoft.utazo.R;
import com.example.mobsoft.utazo.UtazoApplication;
import com.example.mobsoft.utazo.ui.destinations.DestinationsActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen{

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UtazoApplication.injector.inject(this);
        Button btnShowDestinations = (Button) findViewById(R.id.showDestinations);
        btnShowDestinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.showDestinations();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showDestinations() {
        Intent intent = new Intent(getApplicationContext(), DestinationsActivity.class);
        startActivity(intent);
    }
}
