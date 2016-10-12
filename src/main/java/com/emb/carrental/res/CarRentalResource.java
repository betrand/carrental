package com.emb.carrental.res;

import com.emb.carrental.app.control.RentalService;
import com.emb.carrental.util.InvalidDistanceException;
import com.emb.carrental.util.LOG;
import com.emb.carrental.util.Trip;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author bu_000
 */
@Path("CarRental")
public class CarRentalResource {

    @GET
    @Path("calculateTotalExpense/{vehicleType}/{engineType}/{actype}/{trip}/{noOfPassengers}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateTotalExpense(
            @PathParam("vehicleType") String vehicleType,
            @PathParam("engineType") String engineType,
            @PathParam("actype") String type,
            @PathParam("trip") String trip,
            @PathParam("noOfPassengers") String noOfPassengers) {

        LOG.info("calculateTotalExpense", vehicleType);

        Trip trip_ = new Trip();
        trip_.setVehicleType(vehicleType);
        trip_.setEngineType(engineType);
        trip_.setType(type);
        trip_.setTrip(trip);
        trip_.setNoOfPassengers(Integer.parseInt(noOfPassengers));

        double totalExpenseForTrip = 0;
        try {
            RentalService rentalService = new RentalService();
            totalExpenseForTrip = rentalService.calculateTotalExpenseForTrip(trip_);
        } catch (InvalidDistanceException ide) {
            throw new WebApplicationException("Invalid Distance", Response.Status.NO_CONTENT);
        }
        LOG.info("totalExpenseForTrip", totalExpenseForTrip);
        return String.valueOf(totalExpenseForTrip);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("calculateTotalExpenses")
    public JsonObject calculateTotalExpenses(Trip trip_) {
        LOG.info("calculateTotalExpenses", trip_);

        double totalExpenseForTrip = 0;
        try {
            RentalService rentalService = new RentalService();
            totalExpenseForTrip = rentalService.calculateTotalExpenseForTrip(trip_);
        } catch (InvalidDistanceException ide) {
            throw new WebApplicationException("Invalid Distance", Response.Status.NO_CONTENT);
        }
        return Json.createObjectBuilder().add("TotalExpense", totalExpenseForTrip).build();
    }

}
