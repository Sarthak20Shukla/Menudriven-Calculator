package com.example.menudrivencalculator

sealed class calculatoroperation(val symbol:String){
    object Add:calculatoroperation("+")
    object Subtract:calculatoroperation("-")
    object multiply:calculatoroperation("*")
    object divide:calculatoroperation("/")

}
