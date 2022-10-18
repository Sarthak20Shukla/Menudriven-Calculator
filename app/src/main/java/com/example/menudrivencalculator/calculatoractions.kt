package com.example.menudrivencalculator

sealed class calculatoractions {
    data class Number(val number: Int): calculatoractions()
    object Clear: calculatoractions()
    object Delete: calculatoractions()
    object Calculate: calculatoractions()
    object Decimal: calculatoractions()
    data class Operation(val operation: calculatoroperation): calculatoractions()


}