package br.com.erudio.converters

object NumberConverter {
    fun isNumeric(value: String?): Boolean {
        if (value.isNullOrBlank()) {
            return false
        }

        val number = value.replace(",".toRegex(), ".")
        val matchIsNumeric = number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())

        return matchIsNumeric
    }

    fun convertDouble(value: String?): Double {
        if (value.isNullOrBlank()) {
            return 0.0
        }

        val number = value.replace(",".toRegex(), ".")
        return if (isNumeric(number)) {
            number.toDouble()
        } else {
            0.0
        }
    }
}