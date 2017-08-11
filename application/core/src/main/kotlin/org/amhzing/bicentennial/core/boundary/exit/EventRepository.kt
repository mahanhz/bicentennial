package org.amhzing.bicentennial.core.boundary.exit

import org.amhzing.bicentennial.core.domain.root.Event
import org.amhzing.bicentennial.core.domain.valueobject.Id


interface EventRepository {

    fun events(): List<Event>

    fun event(id: Id): Event
}