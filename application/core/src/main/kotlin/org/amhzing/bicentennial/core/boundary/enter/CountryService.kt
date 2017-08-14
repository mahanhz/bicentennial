package org.amhzing.bicentennial.core.boundary.enter

import org.amhzing.bicentennial.core.domain.valueobject.Country


interface CountryService {

    fun countries(): List<Country>
}