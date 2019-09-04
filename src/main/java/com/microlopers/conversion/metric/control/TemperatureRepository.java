package com.microlopers.conversion.metric.control;

import com.microlopers.conversion.metric.entity.TemperatureResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Dalibor Adamus
 */
@Service
public class TemperatureRepository {

    private static final double CELSIUS_TO_KELVIN_TEMPERATURE_DIFFERENCE = 273.15;
    private static final double CELSIUS_TO_FAHRENHEIT_TEMPERATURE_MULTIPLIER = 1.8;
    private static final int FAHRENHEIT_FREEZING_POINT_TEMPERATURE = 32;

    public TemperatureResult convertCelsius(BigDecimal value, int scale, RoundingMode roundingMode) {
        TemperatureResult result = new TemperatureResult();

        result.setKelvin(value.add(BigDecimal.valueOf(CELSIUS_TO_KELVIN_TEMPERATURE_DIFFERENCE)).setScale(scale, roundingMode));
        result.setCelsius(value.setScale(scale, roundingMode));
        result.setFahrenheit(value.multiply(BigDecimal.valueOf(CELSIUS_TO_FAHRENHEIT_TEMPERATURE_MULTIPLIER)).add(BigDecimal.valueOf(FAHRENHEIT_FREEZING_POINT_TEMPERATURE)).setScale(scale, roundingMode));

        return result;
    }

    public TemperatureResult convertKelvin(BigDecimal value, int scale, RoundingMode roundingMode) {
        TemperatureResult result = new TemperatureResult();

        result.setKelvin(value.setScale(scale, roundingMode));
        result.setCelsius(value.subtract(BigDecimal.valueOf(CELSIUS_TO_KELVIN_TEMPERATURE_DIFFERENCE)).setScale(scale, roundingMode));
        result.setFahrenheit(value.subtract(BigDecimal.valueOf(CELSIUS_TO_KELVIN_TEMPERATURE_DIFFERENCE)).multiply(BigDecimal.valueOf(CELSIUS_TO_FAHRENHEIT_TEMPERATURE_MULTIPLIER)).add(BigDecimal.valueOf(FAHRENHEIT_FREEZING_POINT_TEMPERATURE)).setScale(scale, roundingMode));

        return result;
    }

    public TemperatureResult convertFahrenheit(BigDecimal value, int scale, RoundingMode roundingMode) {
        TemperatureResult result = new TemperatureResult();

        result.setKelvin(value.subtract(BigDecimal.valueOf(FAHRENHEIT_FREEZING_POINT_TEMPERATURE)).divide(BigDecimal.valueOf(CELSIUS_TO_FAHRENHEIT_TEMPERATURE_MULTIPLIER), 100, roundingMode).add(BigDecimal.valueOf(CELSIUS_TO_KELVIN_TEMPERATURE_DIFFERENCE)).setScale(scale, roundingMode));
        result.setCelsius(value.subtract(BigDecimal.valueOf(FAHRENHEIT_FREEZING_POINT_TEMPERATURE)).divide(BigDecimal.valueOf(CELSIUS_TO_FAHRENHEIT_TEMPERATURE_MULTIPLIER), scale, roundingMode));
        result.setFahrenheit(value.setScale(scale, roundingMode));

        return result;
    }
}
