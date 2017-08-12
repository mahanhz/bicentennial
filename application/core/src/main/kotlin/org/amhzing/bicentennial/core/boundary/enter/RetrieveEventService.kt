package org.amhzing.bicentennial.core.boundary.enter

import org.amhzing.bicentennial.core.domain.root.Event

interface RetrieveEventService {

    fun events(latitude: Double, longitude: Double, distance: Int): List<Event>
}