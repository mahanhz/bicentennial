package org.amhzing.bicentennial.data.jpa.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseAuditingEntity {

    @Version
    var version: Int = 0

    @CreatedDate
    lateinit var createdDate: Date

    @CreatedBy
    lateinit var createdBy: String

    @LastModifiedDate
    lateinit var lastModifiedDate: Date

    @LastModifiedBy
    lateinit var lastModifiedBy: String
}