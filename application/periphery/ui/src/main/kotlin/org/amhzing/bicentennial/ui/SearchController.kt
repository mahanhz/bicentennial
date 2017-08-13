package org.amhzing.bicentennial.ui

import com.google.maps.GeoApiContext
import com.google.maps.GeocodingApi
import org.amhzing.bicentennial.adapter.SearchEventAdapter
import org.amhzing.bicentennial.ui.model.SearchEvent
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
@RequestMapping(path = arrayOf("/search"))
class SearchController(private val searchEventAdapter: SearchEventAdapter) {

    @GetMapping
    fun search(@Valid searchEvent: SearchEvent,
               bindingResult: BindingResult,
               model: Model) : String {

        if (bindingResult.hasErrors()) {
            return "searchResults"
        }

        var fullAddress = searchEvent.address
        if (!searchEvent.address.contains(searchEvent.country, true)) {
            fullAddress += " " + searchEvent.country
        }

        val context = GeoApiContext.Builder()
                .apiKey(System.getProperty("bicentennial.google.api.key"))
                .build()

        val req = GeocodingApi.newRequest(context).address(fullAddress)

        try {
            val result = req.await()

            val location = result[0].geometry.location
            val events = searchEventAdapter.events(location.lat, location.lng, searchEvent.distance)
            model.addAttribute("events", events)
        } catch (e: Exception) {
            System.out.println("Mahan an error" + e);
        }

        return "searchResults"
    }
}