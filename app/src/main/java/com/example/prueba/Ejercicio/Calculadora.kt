package com.example.prueba.Ejercicio

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.*
import com.example.prueba.R
import kotlin.math.cos
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun calculadora() {
    val context = LocalContext.current //contexto de la aplicación, espacio de trabajo
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var suma by remember { mutableStateOf(0) }
    var resta by remember { mutableStateOf(0) }
    var multiplicacion by remember { mutableStateOf(0) }
    var division by remember { mutableStateOf(0) }
    var seno by remember { mutableStateOf(0.0) }
    var coseno by remember { mutableStateOf(0.0) }


    // antalla y va acompañado de item
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp)
            .border(2.dp, Color.Red)
            .shadow(8.dp),
        verticalArrangement = Arrangement.Center,

        ) {
        item {
            Text(
                text = "Calculadora",
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.pc),
                contentDescription = "Imagen"
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Ingrese Primer Valor",
                color = Color.Blue,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,

                )
            Spacer(modifier = Modifier.height(26.dp)) // espacio entre componentes

            TextField(
                value = numero1,
                onValueChange = { numero1 = it },
                label = { Text("Ingrese Primer Valor") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = true,
                trailingIcon = { Icon(Icons.Default.Edit, contentDescription = "Clear text") },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(26.dp)) // espacio entre componentes

            Text(
                text = "Segundo Valor",
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            TextField(
                value = numero2, // nombre que tiene la variable
                onValueChange = { numero2 = it },
                label = { Text("Ingrese Segundo Valor") }, // Texto dentro de la caja
                trailingIcon = { Icon(Icons.Default.Edit, contentDescription = "Clear text") },
                placeholder = { Text("Escribe algo...") }, // Texto se borra al escribir
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                border = BorderStroke(2.dp, Color.Red),

                onClick = {
                    val num1 = numero1.toIntOrNull() ?: 0
                    val num2 = numero2.toIntOrNull() ?: 0
                    suma = num1 + num2
                    Toast.makeText(context, "La suma es: $suma", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Icono de sumar",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sumar")

            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val num1 = numero1.toIntOrNull() ?: 0
                    val num2 = numero2.toIntOrNull() ?: 0
                    resta = num1 - num2
                    Toast.makeText(context, "La resta es: $resta", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxWidth()

            ) {
                Text("Restar")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val num1 = numero1.toIntOrNull() ?: 0
                    val num2 = numero2.toIntOrNull() ?: 0
                    division = num1 / num2
                    Toast.makeText(context, "La division es: $division", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxWidth()


            ) {
                Text("Dividir")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val num1 = numero1.toInt()
                    val num2 = numero2.toInt()
                    multiplicacion = num1 * num2
                    Toast.makeText(
                        context,
                        "La multiplicacion es: $multiplicacion",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier.fillMaxWidth()


            ) {
                Text("Multiplicar")
            }


        }
        item {
            LazyRow (
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.Center, // Centra los elementos en el LazyRow
                verticalAlignment = Alignment.CenterVertically // Asegura que los elementos estén centrados verticalmente
            ){ // Centra los elementos en el LazyRow

                item {
                    Button(border = BorderStroke(2.dp, Color.Red),
                        modifier = Modifier.padding(horizontal = 15.dp) // Opcional: Espaciado vertical adicional
                        ,
                        onClick = {
                            val num1 = numero1.toDouble()
                            seno = sin(num1)
                            Toast.makeText(
                                context,
                                "El Seno del angulo es: $seno",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        ) {
                        Text(text = "Sen (x)")

                    }
                    Button(border = BorderStroke(2.dp, Color.Red),
                        onClick = {
                            val num1 = numero1.toDouble()
                            coseno = cos(num1)
                            Toast.makeText(
                                context,
                                "El Coseno del angulo es: $coseno",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                        Text(text = "Cos (x)")

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun inicio() {
    calculadora()
}
