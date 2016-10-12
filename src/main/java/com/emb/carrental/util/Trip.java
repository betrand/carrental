package com.emb.carrental.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bu_000
 */
public class Trip {

    private String vehicleType; // e.g. Swift
    private String engineType;  // e.g. Diesel
    private String type;        // AC or Non AC
    private String trip;        // e.g. Pune-Mumbai-Bangalore-Pune
    private int noOfPassengers;

    public Trip(String vehicleType, String engineType, String type,
            String trip, int noOfPassengers) {
        this.vehicleType = vehicleType;
        this.engineType = engineType;
        this.type = type;
        this.trip = trip;
        this.noOfPassengers = noOfPassengers;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public List<String> getDistances() {
        List<String> distances = new ArrayList<>();
        List<String> points = new ArrayList<>();

        points.addAll(Arrays.asList(trip.split("-")));

        while (points.size() > 1) {
            distances.add(distance(points.get(0), points.get(1)));
            points.remove(points.get(0));
        }
        return distances;
    }

    private String distance(String from, String to) {
        return new StringBuilder().append(from).append("-").append(to).toString();
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder("Trip{");
        toStringBuilder.append("VehicleType=").append(this.vehicleType);
        toStringBuilder.append(", EngineType=").append(this.engineType);
        toStringBuilder.append(", Type=").append(this.type);
        toStringBuilder.append(", Trip=").append(this.trip);
        toStringBuilder.append(", NoOfPassengers=").append(this.noOfPassengers);
        toStringBuilder.append('}');
        return toStringBuilder.toString();
    }

}
