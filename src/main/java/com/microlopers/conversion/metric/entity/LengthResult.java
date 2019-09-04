package com.microlopers.conversion.metric.entity;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class LengthResult {

    /* Metric System */
    @ApiModelProperty(example = "1000000", position = 1)
    private BigDecimal millimeters;
    @ApiModelProperty(example = "100000", position = 2)
    private BigDecimal centimeters;
    @ApiModelProperty(example = "10000", position = 3)
    private BigDecimal decimeters;
    @ApiModelProperty(example = "1000", position = 4)
    private BigDecimal meters;
    @ApiModelProperty(example = "1", position = 5)
    private BigDecimal kilometers;

    /* Imperial and US customary measurement systems */
    @ApiModelProperty(example = "39370", position = 6)
    private BigDecimal inches;
    @ApiModelProperty(example = "3280.8", position = 7)
    private BigDecimal feet;
    @ApiModelProperty(example = "1093.6", position = 8)
    private BigDecimal yards;
    @ApiModelProperty(example = "0.62137", position = 9)
    private BigDecimal miles;

    public BigDecimal getMillimeters() {
        return millimeters;
    }

    public void setMillimeters(BigDecimal millimeters) {
        this.millimeters = millimeters;
    }

    public BigDecimal getCentimeters() {
        return centimeters;
    }

    public void setCentimeters(BigDecimal centimeters) {
        this.centimeters = centimeters;
    }

    public BigDecimal getDecimeters() {
        return decimeters;
    }

    public void setDecimeters(BigDecimal decimeters) {
        this.decimeters = decimeters;
    }

    public BigDecimal getMeters() {
        return meters;
    }

    public void setMeters(BigDecimal meters) {
        this.meters = meters;
    }

    public BigDecimal getKilometers() {
        return kilometers;
    }

    public void setKilometers(BigDecimal kilometers) {
        this.kilometers = kilometers;
    }

    public BigDecimal getInches() {
        return inches;
    }

    public void setInches(BigDecimal inches) {
        this.inches = inches;
    }

    public BigDecimal getFeet() {
        return feet;
    }

    public void setFeet(BigDecimal feet) {
        this.feet = feet;
    }

    public BigDecimal getYards() {
        return yards;
    }

    public void setYards(BigDecimal yards) {
        this.yards = yards;
    }

    public BigDecimal getMiles() {
        return miles;
    }

    public void setMiles(BigDecimal miles) {
        this.miles = miles;
    }
}
