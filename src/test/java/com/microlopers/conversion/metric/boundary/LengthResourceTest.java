package com.microlopers.conversion.metric.boundary;

import com.microlopers.conversion.metric.control.TemperatureRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author Dalibor Adamus
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class LengthResourceTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TemperatureRepository repository;

    @ParameterizedTest
    @CsvSource({
            "/length/kilometers,1,10", // kilometers, valid scale
            "/length/meters,1,-5", // meters, invalid scale
            "/length/meters,5,1000", // meters, invalid scale
    })
    void convertLengthTest(String path, String value, int scale) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(path + "/" + value + (scale != -1 ? "?scale=" + scale : ""));
        this.mvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON + ";charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"millimeters\":")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"centimeters\":")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"decimeters\":")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"meters\":")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"kilometers\":")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"feet\":")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"yards\":")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"miles\":")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"miles\":")));
    }
}
