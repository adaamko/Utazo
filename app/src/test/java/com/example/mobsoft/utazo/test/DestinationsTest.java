package com.example.mobsoft.utazo.test;

import com.example.mobsoft.utazo.BuildConfig;
import com.example.mobsoft.utazo.interactor.destinations.DestinationsRepositoryInteractor;
import com.example.mobsoft.utazo.mock.MockRepository;
import com.example.mobsoft.utazo.repository.Repository;
import com.example.mobsoft.utazo.ui.destinations.DestinationsPresenter;
import com.example.mobsoft.utazo.ui.destinations.DestinationsScreen;
import com.example.mobsoft.utazo.ui.details.DetailsPresenter;

import org.junit.After;
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

    @After
    public void tearDown() {
        destinationsPresenter.detachScreen();
    }
}
