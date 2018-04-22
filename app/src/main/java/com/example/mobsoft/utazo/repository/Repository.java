package com.example.mobsoft.utazo.repository;

import android.content.Context;

import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

public interface Repository {
    void open(Context context);

    void close();

    List<Destination> getDestinations();

    void saveDestination(Destination destination);

    void updateDestination(Destination destination);

    void removeDestination(Destination destination);

    boolean existsInDB(Destination destination);
}
