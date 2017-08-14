package org.amhzing.bicentennial.data.jpa.entity

import javax.persistence.*

@Entity(name = "cluster_t")
class ClusterEntity : BaseAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(nullable = false, length = 100)
    var name: String = ""

    @ManyToOne(fetch = FetchType.LAZY)
    var country: CountryEntity = CountryEntity()

    // Needed by JPA
    protected constructor() {}

    constructor(id: Long, country: CountryEntity) {
        this.id = id
        this.country = country
    }
}