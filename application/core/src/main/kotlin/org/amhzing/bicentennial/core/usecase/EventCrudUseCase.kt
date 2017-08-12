package org.amhzing.bicentennial.core.usecase

import org.amhzing.bicentennial.core.boundary.enter.CrudEvent
import org.amhzing.bicentennial.core.boundary.exit.CrudEventRepository
import org.amhzing.bicentennial.core.domain.root.Event
import org.amhzing.bicentennial.core.domain.valueobject.Id


class EventCrudUseCase(private val crudEventRepository: CrudEventRepository) : CrudEvent {

    override fun create(event: Event) {
        crudEventRepository.create(event)
    }

    override fun update(event: Event) {
        crudEventRepository.update(event)
    }

    override fun delete(id: Id) {
        crudEventRepository.delete(id)
    }
}