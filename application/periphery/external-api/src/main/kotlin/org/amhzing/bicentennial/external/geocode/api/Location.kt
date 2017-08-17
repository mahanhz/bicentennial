package org.amhzing.bicentennial.external.geocode.api

data class Location(val latitude: Double = 0.0,
                    val longitude: Double = 0.0,
                    val formattedAddress: String = "") {

    enum class Failure {
        RESULT_IS_EMPTY,
        SERVICE_IS_DOWN
    }
}