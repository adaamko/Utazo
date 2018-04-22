package com.example.mobsoft.utazo.interactor.destinations.event;

import com.example.mobsoft.utazo.model.Destination;

import java.util.List;

public class GetDestinationEvent {
    private Destination destination;
    private Throwable throwable;

    public GetDestinationEvent() {
    }

    public GetDestinationEvent(Destination destination, Throwable throwable) {
        this.destination = destination;
        this.throwable = throwable;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
