package com.microlopers.conversion.metric.boundary;

import com.microlopers.conversion.metric.control.LengthRepository;
import com.microlopers.conversion.metric.entity.LengthResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Dalibor Adamus
 */
@RestController
@RequestMapping("/length")
@Api(tags = "Length")
public class LengthResource {

    private static final int DEFAULT_SCALE = 20;
    private static final String DEFAULT_SCALE_STR = "20";
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    @Autowired
    LengthRepository repository;

    @GetMapping("/kilometers/{value}")
    @ApiOperation(value = "Convert kilometers", response = LengthResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully converted")
        }
    )
    public LengthResult convertKilometers(
            @ApiParam(value = "Value in kilometers", example = "125.25", required = true) @PathVariable("value") BigDecimal value,
            @ApiParam(value = "Scale (number of decimal places)", example = DEFAULT_SCALE_STR) @RequestParam("scale") int scale) {

        return repository.convertKilometers(value, checkScale(scale), ROUNDING_MODE);
    }

    @GetMapping("/meters/{value}")
    @ApiOperation(value = "Convert meters", response = LengthResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully converted")
        }
    )
    public LengthResult convertMeters(
            @ApiParam(value = "Value in meters", example = "125.25", required = true) @PathVariable("value") BigDecimal value,
            @ApiParam(value = "Scale (number of decimal places)", example = DEFAULT_SCALE_STR) @RequestParam("scale") int scale) {
        return repository.convertMeters(value, checkScale(scale), ROUNDING_MODE);
    }

    private int checkScale(int scale) {
        return 0 <= scale && scale <= 100 ? scale : DEFAULT_SCALE;
    }
}
