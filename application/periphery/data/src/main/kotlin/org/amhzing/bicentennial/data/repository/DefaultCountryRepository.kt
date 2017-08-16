package org.amhzing.bicentennial.data.repository

import org.amhzing.bicentennial.core.boundary.exit.CountryRepository
import org.amhzing.bicentennial.core.domain.valueobject.Country
import org.amhzing.bicentennial.data.cache.COUNTRIES_CACHE_NAME
import org.amhzing.bicentennial.data.jpa.entity.CountryEntity
import org.amhzing.bicentennial.data.jpa.repository.CountryJpaRepository
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable

@CacheConfig(cacheNames = arrayOf(COUNTRIES_CACHE_NAME))
class DefaultCountryRepository(val countryJpaRepository: CountryJpaRepository) : CountryRepository {

    @Cacheable(key = "#root.caches[0].name", unless = "#result == null")
    override fun countries(): List<Country> {
        val countries = countryJpaRepository.findAll()

        return countries.map(this::country)
    }

    private fun country(country: CountryEntity): Country {
        return Country(country.id,  country.locale)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(DefaultCountryRepository::class.java)
    }
}