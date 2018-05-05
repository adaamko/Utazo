package com.example.mobsoft.utazo.mock;

import android.support.annotation.NonNull;

import com.example.mobsoft.utazo.model.Country;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.network.DestinationsApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockDestinationsApi implements DestinationsApi {
    @Override
    public Call<Destination> updateDestination(Destination body) {
        return null;
    }

    @Override
    public Call<Destination> addDestination(Destination body) {
        return null;
    }

    @Override
    public Call<Destination> findDestinationById(Long id) {
        return null;
    }

    @Override
    public Call<Void> deleteDestinationById(Long id) {
        return null;
    }

    @Override
    public Call<List<Destination>> getDestinations() {
        final List<Destination> destinations = new ArrayList<Destination>();
        Destination destination = new Destination();

        destination.setImage("image");
        destination.setCountry("Czech Republic");
        destination.setName("Prague Castle");
        destinations.add(destination);

        Call<List<Destination>> call = new Call<List<Destination>>() {
            @Override
            public Response<List<Destination>> execute() throws IOException {
                return Response.success(destinations);
            }

            @Override
            public void enqueue(Callback<List<Destination>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Destination>> clone() {
                return null;
            }
        };

        return call;
    }
}
