package com.emb.carrental.res;

import com.emb.carrental.app.Swift;
import com.emb.carrental.app.Vehicle;
import com.emb.carrental.util.InvalidDistanceException;
import com.emb.carrental.util.Trip;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author bu_000
 */
@Path("CarRental")
public class CarRentalResource {

    @GET
    @Path("calculateTotalExpense")
    public String calculateTotalExpense() {
        Trip trip_ = new Trip();
        trip_.setVehicleType("Swift");
        trip_.setEngineType("Diesel");
        trip_.setType("NON AC");
        trip_.setTrip("Pune-Mumbai-Bangalore-Pune"); // total distance 1600
        trip_.setNoOfPassengers(3);

        Vehicle vehicle = new Swift();
        double totalExpenseForTrip = 0;
        try {
            totalExpenseForTrip = vehicle.calculateTotalExpenseForTrip(trip_);
            System.out.println("totalExpenseForTrip : " + totalExpenseForTrip);
        } catch (InvalidDistanceException ide) {
            throw new WebApplicationException(ide.getMessage(), Response.Status.NO_CONTENT);
        }
        return String.valueOf(totalExpenseForTrip); //Response.ok(expense).build();
    }

}
