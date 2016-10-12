package com.emb.carrental.res;

import com.emb.carrental.util.LOG;
import com.emb.carrental.util.Trip;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bu_000
 */
public class CarRentalResourceIT {

    private Client client;
    private WebTarget webTarget;
    private Trip trip;

    @Before
    public void initClient() {
        this.trip = new Trip();
        this.trip.setVehicleType("Swift");
        this.trip.setEngineType("Diesel");
        this.trip.setType("NON AC");
        this.trip.setTrip("Pune-Mumbai-Bangalore-Pune"); // total distance 1600
        this.trip.setNoOfPassengers(3); // Exceeds limit which is set at 2 for all vehicles, but may be changed

        this.client = ClientBuilder.newClient();
        //webTarget = this.client.target("http://localhost:8888/CarRental/api/CarRental/calculateTotalExpense");
        webTarget = this.client.target("http://localhost:8888/CarRental/api/CarRental/calculateTotalExpense?vehicleType=Swift&engineType=Diesel&type=NON20%AC&trip=Pune-Mumbai-Bangalore-Pune&noOfPassengers=3");
    }

    @Test
    public void calculateTotalExpense() {
        Response response = webTarget
                .path(trip.getVehicleType())
                .path(trip.getEngineType())
                .path(trip.getType())
                .path(trip.getTrip())
                .path(String.valueOf(trip.getNoOfPassengers()))
                .request(MediaType.TEXT_PLAIN)
                .get();

        assertThat(response.getStatus(), is(200));
        String totalExpense = response.readEntity(String.class);
        assertThat(totalExpense, is("27200.0"));
        LOG.info(totalExpense);
    }

}
