package org.amhzing.bicentennial.ui

import org.amhzing.bicentennial.ui.model.SearchEvent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute


@Controller
class IndexController {

    @ModelAttribute
    fun searchEvent(): SearchEvent {
        return SearchEvent("", "", 1)
    }

    @GetMapping(path = arrayOf("/"))
    fun index() = "index"
}