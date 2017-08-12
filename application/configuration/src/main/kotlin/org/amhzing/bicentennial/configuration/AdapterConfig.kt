package org.amhzing.bicentennial.configuration

import org.amhzing.bicentennial.adapter.SearchEventAdapter
import org.amhzing.bicentennial.core.boundary.enter.RetrieveEventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AdapterConfig {

    @Autowired
    lateinit var retrieveEventService: RetrieveEventService

    @Bean
    fun searchEventAdapter(): SearchEventAdapter {
        return SearchEventAdapter(retrieveEventService)
    }
}