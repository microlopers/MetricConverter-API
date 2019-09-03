package com.microlopers.conversion.metric.control;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

/**
 * @author Dalibor Adamus
 */
@Service
public class LengthRepository {

    public BigDecimal convertKilometers(BigDecimal value) {
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
