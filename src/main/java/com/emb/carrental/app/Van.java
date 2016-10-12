package com.emb.carrental.app;

import com.emb.carrental.intf.Rentable;
import com.emb.carrental.util.InvalidDistanceException;
import com.emb.carrental.util.Trip;
import java.io.Serializable;

/**
 *
 * @author bu_000
 */
public class Van extends Vehicle implements Rentable, Serializable {

    @Override
    public double rent(Trip trip) throws InvalidDistanceException {
        this.isRented = trip != null;
        return this.calculateTotalExpenseForTrip(trip);
    }

}
