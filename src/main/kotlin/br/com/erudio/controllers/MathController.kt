package br.com.erudio.controllers

import br.com.erudio.converters.NumberConverter
import br.com.erudio.exceptions.UnsopportedMathOperationException
import br.com.erudio.maths.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {
    private val math: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?, @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsopportedMathOperationException("Por favor, coloque um valor numérico")
        }

        return math.sum(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo))
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String?, @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsopportedMathOperationException("Por favor, coloque um valor numérico")
        }

        return math.subtraction(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo))
    }

    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(
        @PathVariable(value = "numberOne") numberOne: String?, @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsopportedMathOperationException("Por favor, coloque um valor numérico")
        }

        return math.multiplication(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo))
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value = "numberOne") numberOne: String?, @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsopportedMathOperationException("Por favor, coloque um valor numérico")
        }

        return math.division(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo))
    }

    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(
        @PathVariable(value = "numberOne") numberOne: String?, @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsopportedMathOperationException("Por favor, coloque um valor numérico")
        }

        return math.mean(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo))
    }
}