package com.example.jatpackcompose


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Calculadora(){
    var numberAtual by remember { mutableStateOf("0") }
    var operator by remember { mutableStateOf("") }
    var numberAnterior by remember { mutableStateOf("") }

    fun numDigitado(number: String){
        if (numberAtual =="0"){
            numberAtual = number
        }
        else {
            numberAtual += number
        }
    }

    fun opNumber(op: String){
        numberAnterior = numberAtual
        numberAtual = "0"
        operator = op
    }

    fun equacaoNumber(){
        val num1 = numberAnterior.toDoubleOrNull() ?: 0.0
        val num2 = numberAtual.toDoubleOrNull() ?: 0.0
        val resultado = when(operator){
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else "Erro"
            else -> "Erro"
        }
        numberAtual = resultado.toString()
        operator = ""
        numberAnterior = ""
    }


    fun limpar() {
        numberAtual = "0"
        operator = ""
        numberAnterior = ""
    }


    Column (
        modifier = Modifier.background(Color.Gray)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            modifier = Modifier.padding(16.dp),
            text = numberAtual
        )
    Column (
        verticalArrangement = Arrangement.Center
    )
        {

            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Blue),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                 Button(onClick = { numDigitado("1") }) { Text("1") }
                 Button(onClick = { numDigitado("2") }) { Text("2") }
                 Button(onClick = { numDigitado("3") }) { Text("3") }
                 Button(onClick = { opNumber("+") }) { Text("+") }
             }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Blue),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { numDigitado("4") }) { Text("4") }
                Button(onClick = { numDigitado("5") }) { Text("5") }
                Button(onClick = { numDigitado("6") }) { Text("6") }
                Button(onClick = { opNumber("-") }) { Text("-") }
            }


            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Blue),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { numDigitado("7") }) { Text("7") }
                Button(onClick = { numDigitado("8") }) { Text("8") }
                Button(onClick = { numDigitado("9") }) { Text("9") }
                Button(onClick = { opNumber("*") }) { Text("*") }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Blue),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { limpar() }) { Text("C") }
                Button(onClick = { numDigitado("0") }) { Text("0") }
                Button(onClick = { equacaoNumber() }) { Text("=") }
                Button(onClick = { opNumber("/") }) { Text("/") }
            }

        }


    }

}


@Preview(showBackground = true)
@Composable
fun CalculadoraPreview(){
    Calculadora()
}