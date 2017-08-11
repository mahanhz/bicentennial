package org.amhzing.bicentennial.data.jpa.entity

import com.example.clean.app.data.jpa.entity.Contact
import com.example.clean.app.data.jpa.entity.Location
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "event_t")
class EventEntity : BaseAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var location: Location = Location()
    var contact: Contact = Contact()
    var info: String = ""

    // Needed by JPA
    protected constructor() {}

    constructor(id: Long, location: Location, contact: Contact, info: String) : super() {
        this.id = id
        this.location = location
        this.contact = contact
        this.info = info
    }
}