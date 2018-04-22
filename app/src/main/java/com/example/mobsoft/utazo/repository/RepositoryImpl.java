package com.example.mobsoft.utazo.repository;

import android.content.Context;

import com.example.mobsoft.utazo.model.Destination;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Destination> getDestinations() {
        return SugarRecord.listAll(Destination.class);
    }

    @Override
    public void saveDestination(Destination destination) {
        SugarRecord.saveInTx(destination);
    }

    @Override
    public void updateDestination(Destination destination) {
        SugarRecord.saveInTx(destination);
    }

    @Override
    public void removeDestination(Destination destination) {
        SugarRecord.deleteInTx(destination);
    }

    @Override
    public boolean existsInDB(Destination destination) {
        return SugarRecord.findById(Destination.class, destination.getId()) != null;
    }
}
