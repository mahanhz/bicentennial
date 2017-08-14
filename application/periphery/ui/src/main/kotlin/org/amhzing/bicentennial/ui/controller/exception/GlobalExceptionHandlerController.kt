package org.amhzing.bicentennial.ui.controller.exception

import org.amhzing.bicentennial.ui.controller.UIGlobalExceptionMarker
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import java.util.*
import javax.servlet.http.HttpServletRequest

const val ERROR_VIEW = "error"
const val CUSTOM_MESSAGE_KEY = "customMessage"
const val ERROR_ID_KEY = "errorId"
const val CAME_FROM = "cameFrom"

@ControllerAdvice(basePackageClasses = arrayOf(UIGlobalExceptionMarker::class))
class GlobalExceptionHandlerController {

    @ExceptionHandler
    fun handleException(request: HttpServletRequest, throwable: Throwable): ModelAndView {

        val errorId = UUID.randomUUID()
        logger.error("ErrorId: {} references the following error: ", errorId, throwable)

        val mav = ModelAndView()
        mav.addObject(CAME_FROM, request.requestURI)
        mav.addObject(ERROR_ID_KEY, errorId)
        mav.viewName = ERROR_VIEW

        return mav
    }

    companion object {
        private val logger = LoggerFactory.getLogger(GlobalExceptionHandlerController::class.java)
    }
}
