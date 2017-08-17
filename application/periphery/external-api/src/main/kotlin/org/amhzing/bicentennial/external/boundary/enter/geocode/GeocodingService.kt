package org.amhzing.bicentennial.external.boundary.enter.geocode

import io.atlassian.fugue.Either
import org.amhzing.bicentennial.external.geocode.api.Location

interface GeocodingService {

    fun location(address: String) : Either<Location.Failure, Location>
}