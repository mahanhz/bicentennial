package org.amhzing.bicentennial.core.boundary.enter

import org.amhzing.bicentennial.core.domain.root.Event

interface RetrieveEvent {

    fun events(latitude: Double, longitude: Double): List<Event>
}