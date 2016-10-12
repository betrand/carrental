package com.emb.carrental.app;

/**
 *
 * @author bu_000
 */
public abstract class Vehicle {

    protected String type;                     // Assuming there's only 2 possibilities AC and NON AC we can use boolean. May use Enum too
    protected int maxLimit = 2;                // Assuming there's only 2 possibilities AC and NON AC we can use boolean. May use Enum too
    protected int noOfPassengers;              // No of passengers
}
