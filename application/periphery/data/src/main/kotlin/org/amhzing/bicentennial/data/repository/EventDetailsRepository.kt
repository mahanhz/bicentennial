package org.amhzing.bicentennial.data.repository

import org.amhzing.bicentennial.core.boundary.exit.EventRepository
import org.amhzing.bicentennial.core.domain.root.Event
import org.amhzing.bicentennial.core.domain.valueobject.*
import org.amhzing.bicentennial.data.jpa.entity.EventEntity
import org.amhzing.bicentennial.data.jpa.repository.CountryJpaRepository
import org.amhzing.bicentennial.data.jpa.repository.EventJpaRepository
import java.util.*
import org.amhzing.bicentennial.data.jpa.entity.Contact as ContactEntity
import org.amhzing.bicentennial.data.jpa.entity.Location as LocationEntity


class EventDetailsRepository(val eventJpaRepository: EventJpaRepository,
                             val countryJpaRepository: CountryJpaRepository) : EventRepository {
    override fun events(latitude: Double, longitude: Double, distance: Int): List<Event> {
        val events = eventJpaRepository.findNearbyEvents(latitude, longitude, distance)

        return events.map(this::event)
    }

    private fun event(event: EventEntity): Event {
        return Event(id(event), location(event.location), contact(event.contact), Info(event.info))
    }

    private fun id(event: EventEntity): Id {
        return Id(event.id)
    }

    private fun location(location: LocationEntity): Location {
        val country = countryJpaRepository.findOne(location.country);

        val locale = country?.locale ?: Locale.ENGLISH.language

        val address = Address(Country(location.country, locale), Cluster(location.cluster), location.addressLine)
        val coordinates = Coordinate(location.latitude, location.longitude)

        return Location(address, coordinates)
    }

    private fun contact(contact: ContactEntity): Contact {
        val name = Name(contact.name)
        val email = Email(contact.email)
        val number = PhoneNumber(contact.phoneNumber)

        return Contact(name, email, number)
    }
}