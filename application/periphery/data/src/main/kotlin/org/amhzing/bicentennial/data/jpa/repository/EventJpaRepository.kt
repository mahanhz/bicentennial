package org.amhzing.bicentennial.data.jpa.repository

import org.amhzing.bicentennial.data.jpa.entity.EventEntity
import org.springframework.data.jpa.repository.JpaRepository


interface EventJpaRepository : JpaRepository<EventEntity, Long> {
}