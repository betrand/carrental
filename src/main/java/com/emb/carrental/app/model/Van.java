package com.emb.carrental.app.model;

import com.emb.carrental.intf.Rentable;
import com.emb.carrental.util.InvalidDistanceException;
import com.emb.carrental.util.Trip;
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
public class Van extends Vehicle implements Rentable, Serializable {

    @Override
    public double rent(Trip trip) throws InvalidDistanceException {
        this.isRented = trip != null;
        return this.calculateTotalExpenseForTrip(trip);
    }

}
