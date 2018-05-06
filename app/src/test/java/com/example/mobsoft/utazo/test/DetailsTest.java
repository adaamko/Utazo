package com.example.mobsoft.utazo.test;

import com.example.mobsoft.utazo.BuildConfig;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.model.Destination;
import com.example.mobsoft.utazo.ui.destinations.DestinationsPresenter;
import com.example.mobsoft.utazo.ui.destinations.DestinationsScreen;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;
import com.example.mobsoft.utazo.ui.details.DetailsScreen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import static com.example.mobsoft.utazo.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DetailsTest {
    private DetailsPresenter detailsPresenter;
    private DetailsScreen detailsScreen;

    @Inject
    DestinationsRepositoryInteractor destinationsRepositoryInteractor;

    @Before
    public void setup() throws Exception{
        setTestInjector().inject(this);
        detailsScreen = mock(DetailsScreen.class);
        detailsPresenter = new DetailsPresenter();
        detailsPresenter.attachScreen(detailsScreen);
    }

    @Test
    public void testCreateDestinationNotVisited(){

        Destination paris = new Destination();

        paris.setImage("image");
        paris.setCountry("Czech Republic");
        paris.setName("Prague Castle");
        paris.setDescription("Main City");
        paris.setStatus(Destination.StatusEnum.VISITED);
        detailsPresenter.createDestinationDetails(paris.getName(),paris.getCountry(),paris.getDescription(),false);

        verify(detailsScreen).createDestination(paris.getName(),paris.getCountry(),paris.getDescription(),false);
    }

    @Test
    public void testCreateDestinationVisited(){
        Destination paris = new Destination();

        paris.setImage("image");
        paris.setCountry("Czech Republic");
        paris.setName("Prague Castle");
        paris.setDescription("Main City");
        paris.setStatus(Destination.StatusEnum.VISITED);
        detailsPresenter.createDestinationDetails(paris.getName(),paris.getCountry(),paris.getDescription(),true);

        verify(detailsScreen).createDestination(paris.getName(),paris.getCountry(),paris.getDescription(),true);
    }


    @Test
    public void testReturnDestinations(){
        detailsPresenter.getDestinations();
        verify(detailsScreen).getDestinations();
    }
}
