package org.amhzing.bicentennial.external.geocode

import com.google.maps.GeoApiContext
import com.google.maps.GeocodingApi
import com.google.maps.GeocodingApiRequest
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import io.atlassian.fugue.Either
import org.amhzing.bicentennial.external.boundary.enter.geocode.GeocodingService
import org.amhzing.bicentennial.external.geocode.api.Location
import org.amhzing.bicentennial.external.timing.LogExecutionTime
import org.slf4j.LoggerFactory

const val GEOCODING_GK: String = "geocodingGroupKey"
const val GEOCODING_CK: String = "geocodingCommandKey"
const val GEOCODING_FALLBACK: String = "fallback"

class DefaultGeocodingService : GeocodingService {

    companion object {
        private val logger = LoggerFactory.getLogger(DefaultGeocodingService::class.java)
    }

    @LogExecutionTime
    @HystrixCommand(groupKey = GEOCODING_GK, commandKey = GEOCODING_CK, fallbackMethod = GEOCODING_FALLBACK)
    override fun location(address: String): Either<Location.Failure, Location> {
        val req = geocodingApiRequest(address)

        try {
            val result = req.await()

            if (result.isEmpty()) {
                return Either.left(Location.Failure.RESULT_IS_EMPTY)
            }

            val location = result[0].geometry.location

            return Either.right(Location(location.lat, location.lng, result[0].formattedAddress))
        } catch (e: Exception) {
            logger.error("Unfortunately Google Maps returned this error", e)

            return Either.left(Location.Failure.SERVICE_IS_DOWN)
        }
    }

    fun fallback(address: String): Either<Location.Failure, Location> {
        return Either.left(Location.Failure.SERVICE_IS_DOWN)
    }

    private fun geocodingApiRequest(fullAddress: String): GeocodingApiRequest {
        val context = GeoApiContext.Builder()
                .apiKey(System.getProperty("bicentennial.google.api.key"))
                .build()

        return GeocodingApi.newRequest(context).address(fullAddress)
    }
}