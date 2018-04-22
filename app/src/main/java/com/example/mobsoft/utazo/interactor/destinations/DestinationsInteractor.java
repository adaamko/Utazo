package com.example.mobsoft.utazo.interactor.destinations;

import com.example.mobsoft.utazo.UtazoApplication;
import com.example.mobsoft.utazo.interactor.destinations.event.GetDestinationEvent;
import com.example.mobsoft.utazo.interactor.destinations.event.GetDestinationsEvent;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.network.DestinationsApi;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class DestinationsInteractor {

    @Inject
    DestinationsApi destinationsApi;

    public DestinationsInteractor() {
        UtazoApplication.injector.inject(this);
    }

    public void getDestination(Long destinationId) {
        Call<Destination> destinationQueryCall = destinationsApi.findDestinationById(destinationId);
        GetDestinationEvent event = new GetDestinationEvent();
        try {
            Response<Destination> destinationResponse = destinationQueryCall.execute();
            if (destinationResponse.code() != 200) {
                throw new Exception("It was not a sucessful call");
            }
            Destination destination = new Destination();

            destination.setId(destinationResponse.body().getId());
            destination.setName(destinationResponse.body().getName());
            destination.setDescription(destinationResponse.body().getDescription());
            destination.setCountry(destinationResponse.body().getCountry());
            destination.setImage(destinationResponse.body().getImage());
            destination.setStatus(destinationResponse.body().getStatus());

            event.setDestination(destination);
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void getDestinations() {
        Call<List<Destination>> destinationsQueryCall = destinationsApi.getDestinations();
        GetDestinationsEvent event = new GetDestinationsEvent();
        try {
            Response<List<Destination>> destinationsResponse = destinationsQueryCall.execute();
            if (destinationsResponse.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setDestinations(destinationsResponse.body());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void createDog() {
        // TODO
    }

    public void updateDog() {
        // TODO
    }

    public void deleteDog() {
        // TODO
    }

}
