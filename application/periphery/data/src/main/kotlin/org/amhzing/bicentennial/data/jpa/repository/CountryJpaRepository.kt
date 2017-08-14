package org.amhzing.bicentennial.data.jpa.repository

import org.amhzing.bicentennial.data.jpa.entity.CountryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QueryDslPredicateExecutor


interface CountryJpaRepository : JpaRepository<CountryEntity, String>, QueryDslPredicateExecutor<CountryEntity> {
}