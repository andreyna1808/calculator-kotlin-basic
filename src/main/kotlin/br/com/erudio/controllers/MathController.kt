package br.com.erudio.controllers

import br.com.erudio.exceptions.UnsopportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {
    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw UnsopportedMathOperationException("Por favor, coloque um valor numérico")
        }

        return convertDouble(numberOne) + convertDouble(numberTwo)
    }

    private fun isNumeric(value: String?): Boolean {
        if (value.isNullOrBlank()) {
            return false
        }

        val number = value.replace(",".toRegex(), ".")
        val matchIsNumeric = number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())

        return matchIsNumeric
    }

    private fun convertDouble(value: String?): Double {
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