package com.emb.carrental.app.model;

import com.emb.carrental.util.Database;
import com.emb.carrental.util.InvalidDistanceException;
import com.emb.carrental.util.Trip;
import com.emb.carrental.util.Util;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bu_000
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Bus extends Vehicle implements Serializable {
    private Trip trip;
    private double discountRate = 0.02;

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    /**
     *
     * @param trip
     * @return
     * @throws InvalidDistanceException Buses receive 2% discount on standard
     * Rate
     */
    @Override
    public double calculateTotalExpenseForTrip(Trip trip) throws InvalidDistanceException {
        this.type = trip.getType();
        this.noOfPassengers = trip.getNoOfPassengers();
        rate = new Rate(trip.getEngineType(), isAC());
        double standardRate = rate.getStandardRate();
        rate.setStandardRate(standardRate - (standardRate * discountRate));
        double totalDistance = Database.calculateTotalDistance(trip.getDistances());
        double additionalCharge = 0;

        if (limitIsExceeded()) {
            additionalCharge = rate.getAdditionalChargeRatePerKmAndPerson() * totalDistance * noOfPassengers;
        }
        double totalExpenseForTrip = (rate.getStandardRate() * totalDistance) + additionalCharge;
        return Util.roundOff(totalExpenseForTrip, 2);
    }
}
