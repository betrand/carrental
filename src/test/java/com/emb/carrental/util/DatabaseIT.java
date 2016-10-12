package com.emb.carrental.util;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bu_000
 */
public class DatabaseIT {

    private Database database;
    private List<String> distances;

    @Before
    public void initClient() {
        this.database = new Database();
        distances = new ArrayList<>();
        distances.add("Pune-Mumbai"); // distance = 200.0 KM
        distances.add("Pune-Bangalore");  // distance = 1000.0 KM
    }

    @Test
    public void calculateTotalDistance() throws InvalidDistanceException {
        double totalDistance = this.database.calculateTotalDistance(distances);
        assertThat(totalDistance, is(1200.0));
        distances.add("Bangalore-Pune"); // distance = 1000.0 KM
        totalDistance = this.database.calculateTotalDistance(distances);
        assertThat(totalDistance, is(2200.0));
        LOG.info(String.valueOf(totalDistance));
    }
}
