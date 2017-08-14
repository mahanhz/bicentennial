package org.amhzing.bicentennial.data.repository

import org.amhzing.bicentennial.core.boundary.exit.CountryRepository
import org.amhzing.bicentennial.core.domain.valueobject.Country
import org.amhzing.bicentennial.data.jpa.entity.CountryEntity
import org.amhzing.bicentennial.data.jpa.repository.CountryJpaRepository


class DefaultCountryRepository(val countryJpaRepository: CountryJpaRepository) : CountryRepository {

    override fun countries(): List<Country> {
        val countries = countryJpaRepository.findAll()

        return countries.map(this::country)
    }

    private fun country(country: CountryEntity): Country {
        return Country(country.id,  country.locale)
    }
}