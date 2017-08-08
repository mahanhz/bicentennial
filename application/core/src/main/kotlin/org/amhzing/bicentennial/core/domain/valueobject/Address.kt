package org.amhzing.bicentennial.core.domain.valueobject

import org.apache.commons.lang3.StringUtils.trim
import org.apache.commons.lang3.Validate
import org.apache.commons.lang3.Validate.notBlank

const val ADDRESS_LINE_MAX_LENGTH = 250

class Address(country: Country, cluster: Cluster, line: String) {
    val country: Country
    val cluster: Cluster
    val line: String

    init {
        this.country = country
        this.cluster = cluster
        this.line = validate(line)
    }

    private fun validate(input: String): String {
        val trimmed = trim(notBlank(input))
        Validate.isTrue(trimmed.length <= ADDRESS_LINE_MAX_LENGTH)

        return trimmed
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Address

        if (country != other.country) return false
        if (cluster != other.cluster) return false
        if (line != other.line) return false

        return true
    }

    override fun hashCode(): Int {
        var result = country.hashCode()
        result = 31 * result + cluster.hashCode()
        result = 31 * result + line.hashCode()
        return result
    }

    override fun toString(): String {
        return "Address(country=$country, cluster=$cluster, line='$line')"
    }
}