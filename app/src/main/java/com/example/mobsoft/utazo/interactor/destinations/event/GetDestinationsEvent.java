package com.example.mobsoft.utazo.interactor.destinations.event;

import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

public class GetDestinationsEvent extends BaseEvent{
    private List<Destination> destinations;

    public GetDestinationsEvent() {
    }

    public GetDestinationsEvent(List<Destination> destinations, Throwable throwable) {
        super(throwable);
        this.destinations = destinations;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
