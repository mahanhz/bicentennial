package org.amhzing.bicentennial.core.domain.valueobject

import org.apache.commons.lang3.StringUtils.trim
import org.apache.commons.lang3.Validate
import org.apache.commons.lang3.Validate.notBlank

const val CLUSTER_MAX_LENGTH = 100

class Cluster(name: String) {
    val name: String

    init {
        this.name = validate(name)
    }

    private fun validate(input: String): String {
        val trimmed = trim(notBlank(input))
        Validate.isTrue(trimmed.length <= CLUSTER_MAX_LENGTH)

        return trimmed
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Cluster

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        return "Cluster(name='$name')"
    }
}