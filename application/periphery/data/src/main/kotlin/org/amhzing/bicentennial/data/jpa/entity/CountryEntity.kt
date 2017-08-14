package org.amhzing.bicentennial.data.jpa.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "country_t")
class CountryEntity : BaseAuditingEntity {

    @Id
    var id: String = ""

    @Column(nullable = false, length = 10)
    var locale: String = ""

    // Needed by JPA
    constructor() {}

    constructor(id: String, locale: String) {
        this.id = id
        this.locale = locale
    }
}