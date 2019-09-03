package com.microlopers.conversion.metric.boundary;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Dalibor Adamus
 */
@RestController
@RequestMapping("/length")
@Api(tags="Length Converter")
public class LengthResource {

    @GetMapping("/kilometers/{value}")
    @ApiOperation(value = "Convert kilometers", response = BigDecimal.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully converted")
        }
    )
    public BigDecimal convertKilometers(@ApiParam(value = "Value in kilometers", example = "125.25", required = true) @PathVariable("value") BigDecimal value) {
        return value;
    }

    @GetMapping("/meters/{value}")
    @ApiOperation(value = "Convert meters", response = BigDecimal.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully converted")
        }
    )
    public BigDecimal convertMeters(@ApiParam(value = "Value in meters", example = "125.25", required = true) @PathVariable("value") BigDecimal value) {
        return value;
    }
}
