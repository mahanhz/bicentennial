package org.amhzing.bicentennial.configuration

import org.amhzing.bicentennial.core.boundary.exit.CountryRepository
import org.amhzing.bicentennial.core.boundary.exit.CrudEventRepository
import org.amhzing.bicentennial.core.boundary.exit.EventRepository
import org.amhzing.bicentennial.data.jpa.repository.CountryJpaRepository
import org.amhzing.bicentennial.data.jpa.repository.EventJpaRepository
import org.amhzing.bicentennial.data.jpa.repository.JpaPackageMarker
import org.amhzing.bicentennial.data.repository.DefaultCountryRepository
import org.amhzing.bicentennial.data.repository.DefaultCrudEventRepository
import org.amhzing.bicentennial.data.repository.EventDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = arrayOf(JpaPackageMarker::class))
class DataConfig {

    @Autowired
    lateinit var countryJpaRepository: CountryJpaRepository

    @Autowired
    lateinit var eventJpaRepository: EventJpaRepository

    @Bean
    fun countryRepository(): CountryRepository {
        return DefaultCountryRepository(countryJpaRepository)
    }

    @Bean
    fun eventRepository(): EventRepository {
        return EventDetailsRepository(eventJpaRepository, countryJpaRepository)
    }

    @Bean
    fun crudEventRepository(): CrudEventRepository {
        return DefaultCrudEventRepository(eventJpaRepository)
    }
}