package com.emb.carrental.app;

import com.emb.carrental.util.Constants;

/**
 *
 * @author bu_000
 */
public class Rate {

    private String engineType; // Either Petrol, Diesel, etc. Allows for more types e.g Kerosene, Electric, Water
    private double standardRate = 15;
    private static final int dieselAdjustment = 1;
    private static final int additionalRate = 2;
    private static final int additionalChargeRatePerKmAndPerson = 1;

    public Rate(String engineType, boolean AC) {
        this.engineType = engineType;
        adjustRate(engineType, AC);
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
        adjustRate(engineType);
    }

    public double getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(double standardRate) {
        this.standardRate = standardRate;
    }

    //Encapsulated function
    private void adjustRate(String engineType) {
        if (engineType != null && engineType.equalsIgnoreCase(Constants.DIESEL)) {
            standardRate -= dieselAdjustment;
        }
    }

    private void adjustRate(String engineType, boolean AC) {
        standardRate = 15;
        if (engineType != null && engineType.equalsIgnoreCase(Constants.DIESEL)) {
            standardRate -= dieselAdjustment;
        }
        if (AC) {
            standardRate += additionalRate;
        }
    }

    public static int getAdditionalChargeRatePerKmAndPerson() {
        return additionalChargeRatePerKmAndPerson;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Vehicle Engine{");
        sb.append(" engineType=").append(this.engineType);
        sb.append(", standardRate=").append(this.standardRate);
        sb.append("}");
        return sb.toString();
    }

}
