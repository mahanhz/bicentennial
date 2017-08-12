package org.amhzing.bicentennial.core.boundary.exit

import org.amhzing.bicentennial.core.domain.root.Event


interface EventRepository {

    fun events(latitude: Double, longitude: Double, distance: Int): List<Event>
}