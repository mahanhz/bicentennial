package org.amhzing.bicentennial.ui

import com.google.maps.GeoApiContext
import com.google.maps.GeocodingApi
import com.google.maps.GeocodingApiRequest
import org.amhzing.bicentennial.adapter.SearchEventAdapter
import org.amhzing.bicentennial.ui.model.LocationModel
import org.amhzing.bicentennial.ui.model.SearchEvent
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

const val SEARCH_RESULTS = "searchResults"
const val NO_SEARCH_RESULTS = "noSearchResults"

@Controller
@RequestMapping(path = arrayOf("/search"))
class SearchController(private val searchEventAdapter: SearchEventAdapter) {

    private val logger = LoggerFactory.getLogger(SearchEventAdapter::class.java)

    @GetMapping
    fun search(@Valid searchEvent: SearchEvent,
               bindingResult: BindingResult,
               model: Model) : String {

        if (bindingResult.hasErrors()) {
            return SEARCH_RESULTS
        }

        var fullAddress = searchEvent.address
        if (!searchEvent.address.contains(searchEvent.country, true)) {
            fullAddress += " " + searchEvent.country
        }

        val req = geocodingApiRequest(fullAddress)

        try {
            val result = req.await()

            if (result.isEmpty()) {
                return NO_SEARCH_RESULTS
            }

            val location = result[0].geometry.location
            val events = searchEventAdapter.events(location.lat, location.lng, searchEvent.distance)

            if (events.isEmpty()) {
                return NO_SEARCH_RESULTS
            }

            model.addAttribute("startingPoint", LocationModel(result[0].formattedAddress, location.lat, location.lng))
            model.addAttribute("events", events)
        } catch (e: Exception) {
            logger.error("Unfortunately Google Maps returned this error", e)

            return NO_SEARCH_RESULTS
        }

        return SEARCH_RESULTS
    }

    private fun geocodingApiRequest(fullAddress: String): GeocodingApiRequest {
        val context = GeoApiContext.Builder()
                .apiKey(System.getProperty("bicentennial.google.api.key"))
                .build()

        return GeocodingApi.newRequest(context).address(fullAddress)
    }
}