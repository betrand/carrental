package com.emb.carrental.util;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bu_000
 */
public class TripIT {

    private Trip trip;

    @Before
    public void initClient() {
        this.trip = new Trip();
        this.trip.setTrip("Pune-Mumbai-Bangalore-Pune");
    }

    @Test
    public void getDistances() {
        List<String> distances = this.trip.getDistances();
        assertThat(distances.isEmpty(), is(false));
        assertThat(distances.size(), is(3));
        assertThat(distances.contains("Mumbai-Bangalore"), is(true));
        LOG.info(distances.toString());
    }

}
