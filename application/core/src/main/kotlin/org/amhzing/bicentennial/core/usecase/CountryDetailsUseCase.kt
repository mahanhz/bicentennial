package org.amhzing.bicentennial.core.usecase

import org.amhzing.bicentennial.core.boundary.enter.CountryService
import org.amhzing.bicentennial.core.boundary.exit.CountryRepository
import org.amhzing.bicentennial.core.domain.valueobject.Country


class CountryDetailsUseCase(private val countryRepository: CountryRepository) : CountryService {

    override fun countries(): List<Country> {
        return countryRepository.countries()
    }
}