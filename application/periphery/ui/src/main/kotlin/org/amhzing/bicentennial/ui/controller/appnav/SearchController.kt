package org.amhzing.bicentennial.ui.controller.appnav

import org.amhzing.bicentennial.adapter.SearchEventAdapter
import org.amhzing.bicentennial.external.boundary.enter.geocode.GeocodingService
import org.amhzing.bicentennial.ui.model.LocationModel
import org.amhzing.bicentennial.ui.model.SearchEvent
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
class SearchController(private val searchEventAdapter: SearchEventAdapter,
                       private val geocodingService: GeocodingService) {

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

        val result = geocodingService.location(fullAddress)

        if (result.isLeft) {
            return NO_SEARCH_RESULTS
        }

        val location = result.right().get()

        val events = searchEventAdapter.events(location.latitude, location.longitude, searchEvent.distance)

        if (events.isEmpty()) {
            return NO_SEARCH_RESULTS
        }

        model.addAttribute("startingPoint", LocationModel(location.formattedAddress, location.latitude, location.longitude))
        model.addAttribute("events", events)

        return SEARCH_RESULTS
    }
}