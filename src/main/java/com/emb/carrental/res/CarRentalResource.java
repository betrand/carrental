package com.emb.carrental.res;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author bu_000
 */
@Path("CarRental")
public class CarRentalResource {

    @GET
    @Path("calculateTotalExpense")
    public String calculateTotalExpense() {
        // To quickly test the system e.g get the UI guys to start consuming the service under development
        // return dummy JSON texts
        return "TotalExpense: 12345.00";
    }

}
