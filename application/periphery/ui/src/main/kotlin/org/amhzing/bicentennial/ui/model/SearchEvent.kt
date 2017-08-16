package org.amhzing.bicentennial.ui.model

import org.hibernate.validator.constraints.NotBlank


data class SearchEvent(var country: String = "",
                       @field:NotBlank var address: String = "",
                       var distance: Int = 1) {
}