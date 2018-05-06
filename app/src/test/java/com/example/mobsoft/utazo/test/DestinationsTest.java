package com.example.mobsoft.utazo.test;

import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;

import com.example.mobsoft.utazo.BuildConfig;
import com.example.mobsoft.utazo.R;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.mock.MockRepository;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.repository.Repository;
import com.example.mobsoft.utazo.ui.destinations.DestinationsActivity;
import com.example.mobsoft.utazo.ui.destinations.DestinationsFragment;
import com.example.mobsoft.utazo.ui.destinations.DestinationsPresenter;
import com.example.mobsoft.utazo.ui.destinations.DestinationsScreen;
import com.example.mobsoft.utazo.ui.details.DetailsActivity;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;
import static com.example.mobsoft.utazo.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DestinationsTest {
    private DestinationsPresenter destinationsPresenter;
    private DestinationsScreen destinationsScreen;

    @Inject
    DestinationsRepositoryInteractor destinationsRepositoryInteractor;

    @Before
    public void setup() throws Exception{
        setTestInjector().inject(this);
        destinationsScreen = mock(DestinationsScreen.class);
        destinationsPresenter = new DestinationsPresenter();
        destinationsPresenter.attachScreen(destinationsScreen);
    }

    @Test
    public void testDownloadTopPlaces(){
        destinationsPresenter.showDestinationList();

        ArgumentCaptor<List> cryptoCaptor = ArgumentCaptor.forClass(List.class);
        verify(destinationsScreen).addTopDestinations(cryptoCaptor.capture());
        assertTrue(cryptoCaptor.getValue().size() > 0);
    }

    @Test
    public void testDownloadTopThree(){
        destinationsPresenter.showDestinationList();

        ArgumentCaptor<List> cryptoCaptor = ArgumentCaptor.forClass(List.class);
        verify(destinationsScreen).addTopDestinations(cryptoCaptor.capture());
        assertTrue(cryptoCaptor.getValue().size() == 3);
    }

    @Test
    public void testAddDestination(){
        DestinationsActivity activity = Robolectric.buildActivity(
                DestinationsActivity.class).create().get();
        Intent intent = new Intent(activity.getApplicationContext(), DetailsActivity.class);
        destinationsPresenter.addDestination();

        verify(destinationsScreen).addDestination();
    }

    @Test
    public void  testRefreshDestinations(){
        destinationsPresenter.refreshDestinations();

        Destination paris = new Destination();

        paris.setImage("image");
        paris.setCountry("Czech Republic");
        paris.setName("Prague Castle");
        paris.setDescription("Main City");

        destinationsRepositoryInteractor.createDestination(paris);
        ArgumentCaptor<List> cryptoCaptor = ArgumentCaptor.forClass(List.class);
        verify(destinationsScreen).showDestinations(cryptoCaptor.capture());
        assertTrue(cryptoCaptor.getValue().size() > 0);
    }

    @Test
    public void  testVisitedDestinations(){
        destinationsPresenter.refreshDestinations();

        Destination paris = new Destination();

        paris.setImage("image");
        paris.setCountry("Czech Republic");
        paris.setName("Prague Castle");
        paris.setDescription("Main City");
        paris.setStatus(Destination.StatusEnum.NOT_VISITED);

        destinationsRepositoryInteractor.createDestination(paris);

        paris.setStatus(Destination.StatusEnum.VISITED);
        destinationsRepositoryInteractor.updateDestination(paris);
        ArgumentCaptor<List> cryptoCaptor = ArgumentCaptor.forClass(List.class);
        verify(destinationsScreen).showDestinations(cryptoCaptor.capture());

        Destination last = (Destination) cryptoCaptor.getValue().get(cryptoCaptor.getValue().size()-1);
        assertTrue(last.getStatus() == Destination.StatusEnum.VISITED);
    }

    @Test
    public void  testNotVisitedDestinations(){
        destinationsPresenter.refreshDestinations();

        Destination paris = new Destination();

        paris.setImage("image");
        paris.setCountry("Czech Republic");
        paris.setName("Prague Castle");
        paris.setDescription("Main City");
        paris.setStatus(Destination.StatusEnum.VISITED);

        destinationsRepositoryInteractor.createDestination(paris);

        paris.setStatus(Destination.StatusEnum.NOT_VISITED);
        destinationsRepositoryInteractor.updateDestination(paris);
        ArgumentCaptor<List> cryptoCaptor = ArgumentCaptor.forClass(List.class);
        verify(destinationsScreen).showDestinations(cryptoCaptor.capture());

        Destination last = (Destination) cryptoCaptor.getValue().get(cryptoCaptor.getValue().size()-1);
        assertTrue(last.getStatus() == Destination.StatusEnum.NOT_VISITED);
    }

    @After
    public void tearDown() {
        destinationsPresenter.detachScreen();
    }
}
