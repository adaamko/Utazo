package com.example.mobsoft.utazo.interactor.destinations.event;

public class BaseEvent {
    private Throwable throwable;

    public BaseEvent(){}

    public BaseEvent(Throwable throwable){
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
