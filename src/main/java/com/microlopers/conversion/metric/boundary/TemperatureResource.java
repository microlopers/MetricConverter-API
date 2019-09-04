package com.microlopers.conversion.metric.boundary;

import com.microlopers.conversion.metric.control.TemperatureRepository;
import com.microlopers.conversion.metric.entity.TemperatureResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Dalibor Adamus
 */
@RestController
@RequestMapping("/temperature")
@Api(tags = "Temperature")
public class TemperatureResource {

    private static final int DEFAULT_SCALE = 2;
    private static final String DEFAULT_SCALE_STR = "2";
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    @Autowired
    TemperatureRepository repository;

    @GetMapping("/celsius/{value}")
    @ApiOperation(value = "Convert Celsius", response = TemperatureResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully converted")
        }
    )
    public TemperatureResult convertCelsius(
            @ApiParam(value = "Value in Celsius", example = "100", required = true) @PathVariable("value") BigDecimal value,
            @ApiParam(value = "Scale (number of decimal places)", example = DEFAULT_SCALE_STR) @RequestParam("scale") int scale) {

        return repository.convertCelsius(value, checkScale(scale), ROUNDING_MODE);
    }

    @GetMapping("/kelvin/{value}")
    @ApiOperation(value = "Convert Kelvin", response = TemperatureResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully converted")
        }
    )
    public TemperatureResult convertKelvin(
            @ApiParam(value = "Value in Kelvin", example = "273.15", required = true) @PathVariable("value") BigDecimal value,
            @ApiParam(value = "Scale (number of decimal places)", example = DEFAULT_SCALE_STR) @RequestParam("scale") int scale) {
        return repository.convertKelvin(value, checkScale(scale), ROUNDING_MODE);
    }

    @GetMapping("/fahrenheit/{value}")
    @ApiOperation(value = "Convert Fahrenheit", response = TemperatureResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully converted")
    }
    )
    public TemperatureResult convertFahrenheit(
            @ApiParam(value = "Value in Fahrenheit", example = "32", required = true) @PathVariable("value") BigDecimal value,
            @ApiParam(value = "Scale (number of decimal places)", example = DEFAULT_SCALE_STR) @RequestParam("scale") int scale) {
        return repository.convertFahrenheit(value, checkScale(scale), ROUNDING_MODE);
    }

    private int checkScale(int scale) {
        return 0 <= scale && scale <= 100 ? scale : DEFAULT_SCALE;
    }
}
