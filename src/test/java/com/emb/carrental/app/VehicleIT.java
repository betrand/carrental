package com.emb.carrental.app;

import com.emb.carrental.util.Trip;
import org.junit.Before;

/**
 *
 * @author bu_000
 */
public class VehicleIT {

    private Trip trip;
    private Vehicle vehicle;

    @Before
    public void initClient() {
        this.trip = new Trip();
        this.trip.setTrip("Pune-Mumbai-Bangalore-Pune");
    }

}
