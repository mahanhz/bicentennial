package org.amhzing.bicentennial.core.boundary.exit

import org.amhzing.bicentennial.core.domain.root.Event
import org.amhzing.bicentennial.core.domain.valueobject.Id


interface CrudEventRepository {

    fun create(event: Event)

    fun update(event: Event)

    fun delete(id: Id)
}