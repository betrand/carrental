package com.emb.carrental.app.model;

import com.emb.carrental.util.Constants;
import com.emb.carrental.util.Database;
import com.emb.carrental.util.InvalidDistanceException;
import com.emb.carrental.util.Trip;
import com.emb.carrental.util.Util;

/**
 *
 * @author bu_000
 */
public abstract class Vehicle {

    protected boolean isRented;
    protected String type;                     // Assuming there's only 2 possibilities AC and NON AC we can use boolean. May use Enum too
    protected int maxLimit = 2;                // Assuming there's only 2 possibilities AC and NON AC we can use boolean. May use Enum too
    protected int noOfPassengers;              // No of passengers
    protected Rate rate;                       // Allows for varied rates based on vehicle engine type etc.
    private Trip trip;

    public Vehicle() {
    }

    public boolean isIsRented() {
        return isRented;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public boolean isAC() {
        return this.type == null ? false : this.type.equalsIgnoreCase(Constants.AC);
    }

    public boolean limitIsExceeded() {
        return noOfPassengers > maxLimit;
    }

    /**
     *
     * @param trip
     * @return totalexpense
     * @throws InvalidDistanceException
     */
    public double calculateTotalExpenseForTrip(Trip trip) throws InvalidDistanceException {
        this.type = trip.getType();
        this.noOfPassengers = trip.getNoOfPassengers();
        rate = new Rate(trip.getEngineType(), isAC());
        double distance = Database.calculateTotalDistance(trip.getDistances());
        double additionalCharge = 0;

        if (limitIsExceeded()) {
            additionalCharge = rate.getAdditionalChargeRatePerKmAndPerson() * distance * noOfPassengers;
        }

        double totalExpenseForTrip = (rate.getStandardRate() * distance) + additionalCharge;

        return Util.roundOff(totalExpenseForTrip, 2);
    }

    /**
     *
     * @return double
     * @throws InvalidDistanceException TODO: For sub-classes override here to
     * apply polymorphic behaviours Bus Apply 2% discount here
     */
    public double calculateTotalExpenseForTrip() throws InvalidDistanceException {
        if (trip == null) {
            throw new InvalidDistanceException("Trip is required");
        }
        this.type = trip.getType();
        this.noOfPassengers = trip.getNoOfPassengers();
        rate = new Rate(trip.getEngineType(), isAC());
        double distance = Database.calculateTotalDistance(trip.getDistances());
        double additionalCharge = 0;

        if (limitIsExceeded()) {
            additionalCharge = rate.getAdditionalChargeRatePerKmAndPerson() * distance * noOfPassengers;
        }

        double totalExpenseForTrip = (rate.getStandardRate() * distance) + additionalCharge;

        return Util.roundOff(totalExpenseForTrip, 2);
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder("Vehicle{");
        toStringBuilder.append("Type=").append(this.type);
        toStringBuilder.append(", Max Limit=").append(this.maxLimit);
        toStringBuilder.append(", No Of Passengers=").append(this.noOfPassengers);
        toStringBuilder.append(", Rate=").append(this.rate);
        toStringBuilder.append('}');
        return toStringBuilder.toString();
    }

}
