package com.example.clean.app.data.jpa.entity

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Location(@Column(nullable = false, length = 3) val country: String = "",
                    @Column(nullable = false, length = 100) val cluster: String = "",
                    @Column(nullable = false, length = 250) val addressLine: String = "",
                    val latitude: Double = 0.0,
                    val longitude: Double = 0.0) {
}