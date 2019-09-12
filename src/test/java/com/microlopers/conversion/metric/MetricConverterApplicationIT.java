package com.microlopers.conversion.metric;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test class added ONLY to cover main() invocation not covered by application tests.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MetricConverterApplicationIT {

	@Test
	void main() {
		MetricConverterApplication.main(new String[] {});
	}
}
