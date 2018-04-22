package com.example.mobsoft.utazo.network;

import com.example.mobsoft.utazo.model.Destination;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DestinationsApi {

    /**
     * Update a Place
     * Update a Destination
     * @param body Destination object
     * @return Call<Destination>
     */

    @PUT("places")
    Call<Destination> updateDestination(
            @Body Destination body
    );


    /**
     * Add a new Place
     * Add new Destination
     * @param body Destination object
     * @return Call<Destination>
     */

    @POST("places")
    Call<Destination> addDestination(
            @Body Destination body
    );

    /**
     * Finds destination by Id
     *
     * @param id ID of the returned place
     * @return Call<Destination>
     */

    @GET("places/{id}")
    Call<Destination> findDestinationById(
            @Path("id") Long id
    );


    /**
     * Deletes destination by Id
     *
     * @param id ID of deleted place
     * @return Call<Void>
     */

    @DELETE("places/{id}")
    Call<Void> deleteDestinationById(
            @Path("id") Long id
    );

    /**
     * Get top Places
     * Return Places
     * @return Call<List<Destination>>
     */

    @GET("places/list")
    Call<List<Destination>> getDestinations();
}
