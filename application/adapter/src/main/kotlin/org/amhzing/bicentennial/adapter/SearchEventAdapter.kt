package org.amhzing.bicentennial.adapter

import org.amhzing.bicentennial.adapter.dto.EventDTO
import org.amhzing.bicentennial.core.boundary.enter.RetrieveEventService
import org.amhzing.bicentennial.core.domain.root.Event


class SearchEventAdapter(private val retrieveEventService: RetrieveEventService) {

    fun events(latitude: Double, longitude: Double): List<EventDTO> {
        val events = retrieveEventService.events(latitude, longitude)

        return events.map(this::eventDto)
    }

    private fun eventDto(event: Event) : EventDTO {
        val country = event.location.address.country.code
        val cluster = event.location.address.cluster.name
        val address = event.location.address.line
        val latitude = event.location.coordinate.latitude
        val longitude = event.location.coordinate.longitude
        val contactName = event.contact.name.value
        val contactEmail = event.contact.email.value
        val contactNumber = event.contact.phoneNumber.value
        val info = event.info.value

        return EventDTO(country, cluster, address, latitude, longitude, contactName, contactEmail, contactNumber, info)
    }
}