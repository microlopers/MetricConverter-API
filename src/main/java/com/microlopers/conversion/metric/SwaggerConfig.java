package com.microlopers.conversion.metric;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact(
            "Dalibor Adamus", null, "dalibor.adamus@gmail.com");

    private static final List<VendorExtension> vendorExtensions = new ArrayList<>();

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Metric Converter API", "API for Conversions from/to Metric System", "0.0.1",
            "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", vendorExtensions);

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                // Remove basic-error-controller, operation-handler and web-mvc-links-handler from Swagger UI
                .select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .build();
    }
}