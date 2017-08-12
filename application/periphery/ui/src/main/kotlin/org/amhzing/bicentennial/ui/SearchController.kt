package org.amhzing.bicentennial.ui

import org.amhzing.bicentennial.adapter.SearchEventAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class SearchController(private val searchEventAdapter: SearchEventAdapter) {

    @GetMapping(path = arrayOf("/search"))
    fun search() : String {
        val events = searchEventAdapter.events(59.383526, 17.978573, 5)

        return "searchResults"
    }
}