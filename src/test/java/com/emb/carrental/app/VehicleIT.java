package com.emb.carrental.app;

import com.emb.carrental.util.InvalidDistanceException;
import com.emb.carrental.util.LOG;
import com.emb.carrental.util.Trip;
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
public class VehicleIT {

    private Trip swiftTrip;
    private Trip busTrip;
    private Vehicle bus;
    private Vehicle swift;
    private List<Vehicle> vehicles;

    @Before
    public void initClient() {
        this.swiftTrip = new Trip();
        this.swiftTrip.setVehicleType("Swift");
        this.swiftTrip.setEngineType("Diesel");
        this.swiftTrip.setType("NON AC");
        this.swiftTrip.setTrip("Pune-Mumbai-Bangalore-Pune"); // total distance 1600
        this.swiftTrip.setNoOfPassengers(3); // Exceeds limit which is set at 2 for all vehicles, but may be changed

        this.busTrip = new Trip();
        this.busTrip.setVehicleType("Bus");
        this.busTrip.setEngineType("Petrol");
        this.busTrip.setType("AC");
        this.busTrip.setTrip("Pune-Mumbai-Bangalore-Pune"); // total distance 1600
        this.busTrip.setNoOfPassengers(2);

        this.bus = new Bus();
        this.swift = new Swift();

        this.vehicles = new ArrayList<>();
        vehicles.add(bus);
        vehicles.add(swift);
    }

    @Test
    public void testBusTrip() {
        try {
            double totalExpense = bus.calculateTotalExpenseForTrip(busTrip);
            assertThat(totalExpense, is(26656.0));
            LOG.info(String.valueOf(totalExpense));
        } catch (InvalidDistanceException ide) {
        }
    }

    @Test
    public void testSwiftTrip() {
        try {
            double totalExpense = swift.calculateTotalExpenseForTrip(swiftTrip);
            assertThat(totalExpense, is(27200.0));
            LOG.info(String.valueOf(totalExpense));
        } catch (InvalidDistanceException ide) {
        }
    }

    /*    @Test
    public void testAllTrips() {
    try {
    List<Rentable> rentables = new ArrayList<>();
    Rentable van = new Van();
    Rentable bus_ = new Bus();
    Rentable car = new Car();
    Rentable swift_ = new Swift();
    Rentable SUV = new SUV();
    rentables.add(van);
    rentables.add(bus_);
    rentables.add(car);
    rentables.add(swift_);
    rentables.add(SUV);

    for (Rentable rentable : rentables) {
    rentable.rent(busTrip);
    }

    Rate rate;
    this.swift.setType(swiftTrip.getType());
    this.swift.setNoOfPassengers(swiftTrip.getNoOfPassengers());
    rate = new Rate(swiftTrip.getEngineType(), swift.isAC());

    this.bus.setType(busTrip.getType());
    this.bus.setNoOfPassengers(busTrip.getNoOfPassengers());
    rate = new Rate(busTrip.getEngineType(), bus.isAC());

    for (Vehicle vehicle : vehicles) {
    if (vehicle instanceof Bus) {
    Bus bus = (Bus) vehicle;
    double totalExpense = bus.calculateTotalExpenseForTrip(busTrip);
    assertThat(totalExpense, is(800));
    LOG.info(String.valueOf(totalExpense));
    }
    if (vehicle instanceof Swift) {
    Swift swift = (Swift) vehicle;
    double totalExpense = swift.calculateTotalExpenseForTrip(swiftTrip);
    assertThat(totalExpense, is(800));
    LOG.info(String.valueOf(totalExpense));
    }
    }

    } catch (InvalidDistanceException ide) {
    }
    }*/
}
