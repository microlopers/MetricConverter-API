package com.microlopers.conversion.metric.entity;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class TemperatureResult {

    @ApiModelProperty(example = "273.15", position = 1)
    private BigDecimal kelvin;
    @ApiModelProperty(example = "0", position = 2)
    private BigDecimal celsius;
    @ApiModelProperty(example = "32", position = 3)
    private BigDecimal fahrenheit;

    public BigDecimal getKelvin() {
        return kelvin;
    }

    public void setKelvin(BigDecimal kelvin) {
        this.kelvin = kelvin;
    }

    public BigDecimal getCelsius() {
        return celsius;
    }

    public void setCelsius(BigDecimal celsius) {
        this.celsius = celsius;
    }

    public BigDecimal getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(BigDecimal fahrenheit) {
        this.fahrenheit = fahrenheit;
    }
}
