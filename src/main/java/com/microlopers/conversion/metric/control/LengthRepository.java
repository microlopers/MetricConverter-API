package com.microlopers.conversion.metric.control;

import com.microlopers.conversion.metric.entity.LengthResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Dalibor Adamus
 */
@Service
public class LengthRepository {

    public LengthResult convertKilometers(BigDecimal value, int scale, RoundingMode roundingMode) {
        LengthResult result = new LengthResult();

        result.setInches(value.multiply(BigDecimal.valueOf(39370)).setScale(scale, roundingMode));
        result.setFeet(value.multiply(BigDecimal.valueOf(3280.8)).setScale(scale, roundingMode));
        result.setYards(value.multiply(BigDecimal.valueOf(1093.6)).setScale(scale, roundingMode));
        result.setMiles(value.multiply(BigDecimal.valueOf(0.62137)).setScale(scale, roundingMode));
        result.setMillimeters(value.multiply(BigDecimal.valueOf(1000000)).setScale(scale, roundingMode));
        result.setCentimeters(value.multiply(BigDecimal.valueOf(100000)).setScale(scale, roundingMode));
        result.setDecimeters(value.multiply(BigDecimal.valueOf(10000)).setScale(scale, roundingMode));
        result.setMeters(value.multiply(BigDecimal.valueOf(1000)).setScale(scale, roundingMode));
        result.setKilometers(value.setScale(scale, roundingMode));

        return result;
    }

    public LengthResult convertMeters(BigDecimal value, int scale, RoundingMode roundingMode) {
        LengthResult result = new LengthResult();

        result.setInches(value.multiply(BigDecimal.valueOf(39.370)).setScale(scale, roundingMode));
        result.setFeet(value.multiply(BigDecimal.valueOf(3.2808)).setScale(scale, roundingMode));
        result.setYards(value.multiply(BigDecimal.valueOf(1.0936)).setScale(scale, roundingMode));
        result.setMiles(value.multiply(BigDecimal.valueOf(0.00062137)).setScale(scale, roundingMode));
        result.setMillimeters(value.multiply(BigDecimal.valueOf(1000)).setScale(scale, roundingMode));
        result.setCentimeters(value.multiply(BigDecimal.valueOf(100)).setScale(scale, roundingMode));
        result.setDecimeters(value.multiply(BigDecimal.valueOf(10)).setScale(scale, roundingMode));
        result.setMeters(value.setScale(scale, roundingMode));
        result.setKilometers(value.multiply(BigDecimal.valueOf(0.001)).setScale(scale, roundingMode));

        return result;
    }
}
