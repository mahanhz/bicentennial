package org.amhzing.bicentennial.core.usecase

import org.amhzing.bicentennial.core.boundary.enter.RetrieveEvent
import org.amhzing.bicentennial.core.boundary.exit.EventRepository
import org.amhzing.bicentennial.core.domain.root.Event


class EventDetailsUseCase(private val eventRepository: EventRepository) : RetrieveEvent {

    override fun events(latitude: Double, longitude: Double): List<Event> {
        return eventRepository.events()
    }
}