package org.amhzing.bicentennial.adapter.dto

import com.fasterxml.jackson.annotation.JsonProperty


data class EventDTO(@JsonProperty("country") val country: String = "",
                    @JsonProperty("cluster") val cluster: String = "",
                    @JsonProperty("address") val address: String = "",
                    @JsonProperty("latitude") val latitude: Double = 0.0,
                    @JsonProperty("longitude") val longitude: Double = 0.0,
                    @JsonProperty("contactName") val contactName: String = "",
                    @JsonProperty("contactEmail") val contactEmail: String = "",
                    @JsonProperty("contactNumber") val contactNumber: String = "",
                    @JsonProperty("info") val info: String = "") {
}