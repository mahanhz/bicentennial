package org.amhzing.bicentennial.core.boundary.exit

import org.amhzing.bicentennial.core.domain.valueobject.Country


interface CountryRepository {

    fun countries(): List<Country>
}