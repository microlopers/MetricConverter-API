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
class TemperatureResourceTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TemperatureRepository repository;

    @ParameterizedTest
    @CsvSource({
            "/temperature/celsius,0,10", // celsius, valid scale
            "/temperature/kelvin,0,1000", // kelvin, invalid scale
            "/temperature/fahrenheit,100,-5" // fahrenheit, invalid scale
    })
    void convertTemperatureTest(String path, String value, int scale) throws Exception {
            MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(path + "/" + value + (scale != -1 ? "?scale=" + scale : "")).accept(MediaType.APPLICATION_JSON);
            this.mvc.perform(builder)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON + ";charset=UTF-8"))
                    .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"celsius\":")))
                    .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"kelvin\":")))
                    .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"fahrenheit\":")));
    }
}
