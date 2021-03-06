package org.amhzing.bicentennial.core.domain.valueobject

import org.apache.commons.lang3.StringUtils.trim
import org.apache.commons.lang3.Validate

const val INFO_MAX_LENGTH = 250

class Info(value: String) {
    val value: String

    init {
        this.value = validate(value)
    }

    private fun validate(input: String): String {
        val trimmed = trim(input)
        Validate.isTrue(trimmed.length <= INFO_MAX_LENGTH)

        return trimmed
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Name

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "Info(value='$value')"
    }
}