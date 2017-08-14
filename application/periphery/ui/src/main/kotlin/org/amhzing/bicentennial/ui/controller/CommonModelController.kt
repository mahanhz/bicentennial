package org.amhzing.bicentennial.ui.controller

import org.amhzing.bicentennial.adapter.CountryAdapter
import org.amhzing.bicentennial.adapter.dto.CountryDTO
import org.amhzing.bicentennial.ui.model.CountryModel
import org.amhzing.bicentennial.ui.model.SearchEvent
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute
import java.util.*

const val COUNTRIES_MODEL = "countries"

@ControllerAdvice(basePackageClasses = arrayOf(CommonModelController::class))
class CommonModelController(private val countryAdapter: CountryAdapter) {

    @ModelAttribute
    fun searchEvent(): SearchEvent {
        return SearchEvent("", "", 1)
    }

    @ModelAttribute(COUNTRIES_MODEL)
    fun countries(): List<CountryModel> {
        val countries = countryAdapter.countries()

        return countries.map(this::countryModel)
    }

    private fun countryModel(country: CountryDTO) : CountryModel {
        val locale = Locale(LocaleContextHolder.getLocale().language, country.code)

        return CountryModel(country.code, locale.getDisplayCountry(locale), country.locale)
    }
}