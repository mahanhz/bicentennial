package org.amhzing.bicentennial.data.repository

import com.example.clean.app.data.jpa.entity.Contact
import com.example.clean.app.data.jpa.entity.Location
import org.amhzing.bicentennial.core.boundary.exit.CrudEventRepository
import org.amhzing.bicentennial.core.domain.root.Event
import org.amhzing.bicentennial.core.domain.valueobject.Id
import org.amhzing.bicentennial.data.jpa.entity.EventEntity
import org.amhzing.bicentennial.data.jpa.repository.EventJpaRepository

import org.amhzing.bicentennial.core.domain.valueobject.Location as EventLocation
import org.amhzing.bicentennial.core.domain.valueobject.Contact as EventContact


class DefaultCrudEventRepository(val eventJpaRepository: EventJpaRepository) : CrudEventRepository {
    override fun create(event: Event) {
        eventJpaRepository.save(eventEntity(event))
    }

    override fun update(event: Event) {
        eventJpaRepository.save(eventEntity(event))
    }

    override fun delete(id: Id) {
        eventJpaRepository.delete(id.value)
    }

    private fun eventEntity(event: Event) : EventEntity {
        val id = event.id.value
        val location = location(event.location)
        val contact = contact(event.contact)
        val info = event.info.value

        return EventEntity(id, location, contact, info)
    }

    private fun location(location: EventLocation) : Location {
        return Location(location.address.country.code,
                        location.address.cluster.name,
                        location.address.line,
                        location.coordinate.latitude,
                        location.coordinate.longitude)
    }

    private fun contact(contact: EventContact): Contact {
        return Contact(contact.name.value,
                       contact.email.value,
                       contact.phoneNumber.value)
    }
}