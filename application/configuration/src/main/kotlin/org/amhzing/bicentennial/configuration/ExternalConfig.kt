package org.amhzing.bicentennial.configuration

import org.amhzing.bicentennial.external.boundary.enter.geocode.GeocodingService
import org.amhzing.bicentennial.external.geocode.DefaultGeocodingService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExternalConfig {

    @Bean
    fun geocodingService(): GeocodingService {
        return DefaultGeocodingService();
    }
}