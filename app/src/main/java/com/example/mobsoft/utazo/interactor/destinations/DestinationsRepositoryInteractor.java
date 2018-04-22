package com.example.mobsoft.utazo.interactor.destinations;

import com.example.mobsoft.utazo.UtazoApplication;
import com.example.mobsoft.utazo.interactor.destinations.event.GetDestinationEvent;
import com.example.mobsoft.utazo.interactor.destinations.event.GetDestinationsEvent;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.repository.Repository;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class DestinationsRepositoryInteractor {
    @Inject
    Repository repository;

    public DestinationsRepositoryInteractor() {
        UtazoApplication.injector.inject(this);
    }

    public List<Destination> getDestinations() {
        return repository.getDestinations();
    }

    public void createDestination(Destination destination) {
        repository.saveDestination(destination);
    }

    public void updateDestination(Destination destination) {
        repository.updateDestination(destination);
    }

    public void deleteDestination(Destination destination) {
        repository.removeDestination(destination);
    }
}
