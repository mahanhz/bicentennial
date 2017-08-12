package org.amhzing.bicentennial.configuration

import org.amhzing.bicentennial.core.boundary.enter.CrudEvent
import org.amhzing.bicentennial.core.boundary.exit.CrudEventRepository
import org.amhzing.bicentennial.core.usecase.EventCrudUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UsecaseConfig {

    @Autowired
    lateinit var crudEventRepository: CrudEventRepository

    @Bean
    fun crudEvent(): CrudEvent {
        return EventCrudUseCase(crudEventRepository)
    }
}