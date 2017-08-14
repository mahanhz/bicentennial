package org.amhzing.bicentennial.adapter

import org.amhzing.bicentennial.adapter.dto.CountryDTO
import org.amhzing.bicentennial.core.boundary.enter.CountryService
import org.amhzing.bicentennial.core.domain.valueobject.Country


class CountryAdapter(private val countryService: CountryService) {

    fun countries(): List<CountryDTO> {
        val countries = countryService.countries()

        return countries.map(this::countryDto)
    }

    private fun countryDto(country: Country) : CountryDTO {
        return CountryDTO(country.code, country.locale)
    }
}