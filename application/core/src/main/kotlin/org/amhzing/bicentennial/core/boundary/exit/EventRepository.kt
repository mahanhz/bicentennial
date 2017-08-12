package org.amhzing.bicentennial.core.boundary.exit

import org.amhzing.bicentennial.core.domain.root.Event


interface EventRepository {

    fun events(): List<Event>
}