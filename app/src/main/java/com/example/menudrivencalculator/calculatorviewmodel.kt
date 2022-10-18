package com.example.menudrivencalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.ViewModel

class calculatorviewmodel:ViewModel() {
    var state by mutableStateOf(calculatorstate())
    private set
fun onAction(action: calculatoractions){
    when(action){
        is calculatoractions.Number->enterNumber(action.number)
        is calculatoractions.Decimal->enterDecimal()
        is calculatoractions.Clear->state= calculatorstate()
        is calculatoractions.Operation->enterOperation(action.operation)
        is calculatoractions.Calculate->performCalculation()
        is calculatoractions.Delete->performDeletion()
    }
}

    private fun performDeletion() {
 when{
     state.number2.isNotBlank()->state=state.copy(
         number2=state.number2.dropLast(1)
     )
     state.operation!=null->state=state.copy(operation=null)
     state.number1.isNotBlank()->state=state.copy(number1=state.number1.dropLast(1))
 }
    }

    private fun performCalculation() {
      val number1=state.number1.toDoubleOrNull()
        val number2=state.number2.toDoubleOrNull()
        if(number1!= null&& number2!=null){
        val result=when(state.operation){
           is calculatoroperation.Add->number1+number2
            is calculatoroperation.Subtract->number1-number2
            is calculatoroperation.multiply->number1*number2
            is calculatoroperation.divide->number1/number2
            null->return
        }
        state=state.copy(number1=result.toString().take(15),
        number2 ="",
         operation =null
            )
        }
        }
    private fun enterOperation(operation: calculatoroperation) {
        if(state.number1.isNotBlank()){
            state=state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }
        if (!state.number2.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(number2 = state.number2 + ".")

        }
    }
    private fun enterNumber(number: Int) {
        if(state.operation==null){
            if(state.number1.length >= MAX_NUM_LENGTH){
                return
        }
        state=state.copy(number1 = state.number1+number)
            return
    }
        if(state.number2.length>= MAX_NUM_LENGTH){
            return
        }
        state=state.copy(number2 = state.number2+number)
}
    companion object{
        private const val MAX_NUM_LENGTH= 8
    }
}