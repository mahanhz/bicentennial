package org.amhzing.bicentennial.core.usecase

import org.amhzing.bicentennial.core.boundary.enter.RetrieveEvent
import org.amhzing.bicentennial.core.boundary.exit.EventRepository
import org.amhzing.bicentennial.core.domain.root.Event
import org.amhzing.bicentennial.core.domain.valueobject.Id


class EventDetailsUseCase(private val eventRepository: EventRepository) : RetrieveEvent {

    override fun events(): List<Event> {
        return eventRepository.events()
    }

    override fun event(id: Id): Event {
        return eventRepository.event(id)
    }
}