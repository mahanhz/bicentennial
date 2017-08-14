package org.amhzing.bicentennial.configuration

import org.amhzing.bicentennial.core.boundary.enter.CountryService
import org.amhzing.bicentennial.core.boundary.enter.CrudEventService
import org.amhzing.bicentennial.core.boundary.enter.RetrieveEventService
import org.amhzing.bicentennial.core.boundary.exit.CountryRepository
import org.amhzing.bicentennial.core.boundary.exit.CrudEventRepository
import org.amhzing.bicentennial.core.boundary.exit.EventRepository
import org.amhzing.bicentennial.core.usecase.CountryDetailsUseCase
import org.amhzing.bicentennial.core.usecase.CrudEventUseCase
import org.amhzing.bicentennial.core.usecase.EventDetailsUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UsecaseConfig {

    @Autowired
    lateinit var countryRepository: CountryRepository

    @Autowired
    lateinit var eventRepository: EventRepository

    @Autowired
    lateinit var crudEventRepository: CrudEventRepository

    @Bean
    fun countryService(): CountryService {
        return CountryDetailsUseCase(countryRepository)
    }

    @Bean
    fun retrieveEventService(): RetrieveEventService {
        return EventDetailsUseCase(eventRepository)
    }

    @Bean
    fun crudEventService(): CrudEventService {
        return CrudEventUseCase(crudEventRepository)
    }
}