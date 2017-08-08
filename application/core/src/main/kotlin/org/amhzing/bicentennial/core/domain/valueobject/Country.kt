package org.amhzing.bicentennial.core.domain.valueobject

import org.apache.commons.lang3.StringUtils.trim
import org.apache.commons.lang3.Validate
import org.apache.commons.lang3.Validate.notBlank

const val COUNTRY_CODE_MAX_LENGTH = 3

class Country(code: String, name: String) {
    val code: String
    val name: String

    init {
        this.code = validate(code)
        this.name = notBlank(name)
    }

    private fun validate(input: String): String {
        val trimmed = trim(notBlank(input))
        Validate.isTrue(trimmed.length <= COUNTRY_CODE_MAX_LENGTH)

        return trimmed
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Country

        if (code != other.code) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "Country(code='$code', name='$name')"
    }
}