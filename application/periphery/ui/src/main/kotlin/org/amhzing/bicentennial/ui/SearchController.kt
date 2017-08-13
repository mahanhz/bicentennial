package org.amhzing.bicentennial.ui

import org.amhzing.bicentennial.adapter.SearchEventAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class SearchController(private val searchEventAdapter: SearchEventAdapter) {

    @PostMapping(path = arrayOf("/search"))
    fun search(@RequestParam(value = "country") country: String,
               @RequestParam(value = "address") address: String,
               @RequestParam(value = "distance") distance: Int) : String {
        val events = searchEventAdapter.events(59.383526, 17.978573, 5)

        return "searchResults"
    }
}