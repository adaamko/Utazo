package com.example.mobsoft.utazo.interactor.destinations.event;

import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

public class GetDestinationsEvent {
    private List<Destination> destinations;
    private Throwable throwable;

    public GetDestinationsEvent() {
    }

    public GetDestinationsEvent(List<Destination> destinations, Throwable throwable) {
        this.destinations = destinations;
        this.throwable = throwable;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
