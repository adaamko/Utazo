package com.example.mobsoft.utazo.mock;

import android.content.Context;

import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.repository.Repository;

import java.util.List;

public class MockRepository implements Repository {
    @Override
    public void open(Context context) {

    }

    @Override
    public void close() {

    }

    @Override
    public List<Destination> getDestinations() {
        return null;
    }

    @Override
    public void saveDestination(Destination destination) {

    }

    @Override
    public void updateDestination(Destination destination) {

    }

    @Override
    public void removeDestination(Destination destination) {

    }

    @Override
    public boolean existsInDB(Destination destination) {
        return false;
    }
}
