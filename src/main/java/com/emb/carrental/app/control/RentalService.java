package com.emb.carrental.app.control;

import com.emb.carrental.app.model.Bus;
import com.emb.carrental.app.model.Car;
import com.emb.carrental.app.model.SUV;
import com.emb.carrental.app.model.Swift;
import com.emb.carrental.app.model.Truck;
import com.emb.carrental.app.model.Van;
import com.emb.carrental.util.InvalidDistanceException;
import com.emb.carrental.util.Trip;

/**
 *
 * @author bu_000
 */
public class RentalService {

    public double calculateTotalExpenseForTrip(Trip trip) throws InvalidDistanceException {
        switch (trip.getVehicleType()) {
            case "Bus":
                return new Bus().calculateTotalExpenseForTrip(trip);
            case "Car":
                return new Car().calculateTotalExpenseForTrip(trip);
            case "SUV":
                return new SUV().calculateTotalExpenseForTrip(trip);
            case "Swift":
                return new Swift().calculateTotalExpenseForTrip(trip);
            case "Van":
                return new Van().calculateTotalExpenseForTrip(trip);
            case "Truck":
                return new Truck().calculateTotalExpenseForTrip(trip);
            default:
                return 0;
        }
    }

}
