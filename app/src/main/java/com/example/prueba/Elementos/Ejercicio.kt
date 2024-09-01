package com.example.prueba.Elementos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
fun botones(){
    var numero1 by remember { mutableStateOf("") }
    var textoMostrado by remember { mutableStateOf("") }
    var textIngresado by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Ingrese su nombre",
            fontSize = 10.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(bottom = 3.dp))

        TextField(value = numero1,
            onValueChange = {numero1=it},
            label = { Text(text = "Ingrese su primer nombre")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { }) {
            Text(text = "Mostrar Nombre")
        }
        Button(onClick = {
            numero1=""
        },
            modifier = Modifier.padding(bottom = 8.dp)
            ) {
            Text(text = "Limpiar")
        }
        Text(text = "No se ha ingresado Ningun Nombre",
            modifier = Modifier.padding(bottom = 8.dp))
    }
}