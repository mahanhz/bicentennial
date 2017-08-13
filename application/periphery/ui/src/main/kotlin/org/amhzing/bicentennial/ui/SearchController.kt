package org.amhzing.bicentennial.ui

import com.google.maps.GeoApiContext
import com.google.maps.GeocodingApi
import org.amhzing.bicentennial.adapter.SearchEventAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(path = arrayOf("/search"))
class SearchController(private val searchEventAdapter: SearchEventAdapter) {

    @GetMapping
    fun searchResults() = "searchResults"

    @PostMapping
    fun search(@RequestParam(value = "country") country: String,
               @RequestParam(value = "address") address: String,
               @RequestParam(value = "distance") distance: Int) : String {

        var fullAddress = address
        if (!address.contains(country, true)) {
            fullAddress += " " + country
        }

        val context = GeoApiContext.Builder()
                .apiKey(System.getProperty("bicentennial.google.api.key"))
                .build()

        val req = GeocodingApi.newRequest(context).address(fullAddress)

        try {
            val result = req.await()

            val location = result[0].geometry.location
            val events = searchEventAdapter.events(location.lat, location.lng, distance)
            System.out.println("Mahan this is the event: " + events.get(0).address)
        } catch (e: Exception) {
            System.out.println("Mahan an error" + e);
        }

        return "redirect:/search"
    }
}