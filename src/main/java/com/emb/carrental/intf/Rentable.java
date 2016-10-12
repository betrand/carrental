package com.emb.carrental.intf;

import com.emb.carrental.util.InvalidDistanceException;
import com.emb.carrental.util.Trip;

/**
 *
 * @author bu_000
 */
public interface Rentable {

    public double rent(Trip trip) throws InvalidDistanceException;
}
