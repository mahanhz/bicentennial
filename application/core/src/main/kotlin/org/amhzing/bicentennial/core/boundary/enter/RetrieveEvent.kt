package org.amhzing.bicentennial.core.boundary.enter

import org.amhzing.bicentennial.core.domain.root.Event
import org.amhzing.bicentennial.core.domain.valueobject.Id

interface RetrieveEvent {

    fun events(): List<Event>

    fun event(id: Id): Event
}