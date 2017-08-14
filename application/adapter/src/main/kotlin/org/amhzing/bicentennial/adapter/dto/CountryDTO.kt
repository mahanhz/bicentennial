package org.amhzing.bicentennial.adapter.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CountryDTO(@JsonProperty("code") val code: String = "",
                      @JsonProperty("locale") val locale: String = "") {
}