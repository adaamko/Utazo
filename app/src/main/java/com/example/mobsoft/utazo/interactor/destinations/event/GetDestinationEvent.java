package com.example.mobsoft.utazo.interactor.destinations.event;

import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

public class GetDestinationEvent extends BaseEvent{
    private Destination destination;

    public GetDestinationEvent() {
    }

    public GetDestinationEvent(Destination destination, Throwable throwable) {
        super(throwable);
        this.destination = destination;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
