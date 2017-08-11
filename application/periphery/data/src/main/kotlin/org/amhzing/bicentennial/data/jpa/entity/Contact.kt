package com.example.clean.app.data.jpa.entity

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Contact(@Column(length = 250) val name: String = "",
                   @Column(length = 250) val email: String = "",
                   @Column(length = 250) val phoneNumber: String = "") {
}