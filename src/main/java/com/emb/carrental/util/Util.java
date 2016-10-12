package com.emb.carrental.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author bu_000
 */
public class Util {

    /**
     *
     * @param number
     * @param digits number of decimal digits to round off less than 5
     * @return
     */
    public static long roundOff(double number, int digits) {
        String val = String.valueOf(number);
        int index = val.indexOf(".");
        val = val.substring(index);
        if (val.length() > 4) {
            return new BigDecimal(number).setScale(digits, RoundingMode.UP).longValue();
        }
        return new BigDecimal(number).setScale(digits, RoundingMode.FLOOR).longValue();
    }

}
