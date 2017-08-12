package org.amhzing.bicentennial.data.jpa.repository

import org.amhzing.bicentennial.data.jpa.entity.EventEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QueryDslPredicateExecutor
import org.springframework.data.repository.query.Param

const val HAVERSINE_PART = "(6371 * acos(cos(radians(:lat)) * cos(radians(latitude)) * cos(radians(Longitude) - radians(:lon)) + sin(radians(:lat)) * sin(radians(latitude))))"

interface EventJpaRepository : JpaRepository<EventEntity, Long>, QueryDslPredicateExecutor<EventEntity> {

    @Query("SELECT * FROM event_t WHERE " + HAVERSINE_PART + " < :km ORDER BY " + HAVERSINE_PART, nativeQuery = true)
    fun findNearbyEvents(@Param("lat") latitude: Double, @Param("lon") longitude: Double, @Param("km") distance: Int): List<EventEntity>
}