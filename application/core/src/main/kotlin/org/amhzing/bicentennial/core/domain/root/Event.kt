package org.amhzing.bicentennial.core.domain.root

import org.amhzing.bicentennial.core.domain.valueobject.Contact
import org.amhzing.bicentennial.core.domain.valueobject.Id
import org.amhzing.bicentennial.core.domain.valueobject.Info
import org.amhzing.bicentennial.core.domain.valueobject.Location

data class Event(val id: Id, val location: Location, val contact: Contact, val info: Info) {
}