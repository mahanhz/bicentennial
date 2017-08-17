package org.amhzing.bicentennial.configuration

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.context.annotation.Configuration

@Configuration
@EnableCircuitBreaker
class HystrixConfig {
}