package com.example.mobsoft.utazo.mock;

import android.content.Context;

import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;

public class MockRepository implements Repository {
    List<Destination> destinations = new ArrayList<>();

    @Override
    public void open(Context context) {

    }

    @Override
    public void close() {

    }

    @Override
    public List<Destination> getDestinations() {
        return destinations;
    }

    @Override
    public void saveDestination(Destination destination) {
        destinations.add(destination);
    }

    @Override
    public void updateDestination(Destination destination) {
        for (Destination item : destinations){
            if (item.getId() == destination.getId()){
                item.setStatus(destination.getStatus());
            }
        }
    }

    @Override
    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }

    @Override
    public boolean existsInDB(Destination destination) {
        return false;
    }
}
