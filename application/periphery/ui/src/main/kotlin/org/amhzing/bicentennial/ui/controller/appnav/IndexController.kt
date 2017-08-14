package org.amhzing.bicentennial.ui.controller.appnav

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping(path = arrayOf("/"))
    fun index() = "index"
}