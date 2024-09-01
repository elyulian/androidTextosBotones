package com.example.prueba.Elementos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ejemploTexto() {
    var textIngresado by remember { mutableStateOf("") }
    LazyColumn(modifier = Modifier.padding(16.dp),) {
        item {
            Text(
                text = "Texto Simple",
                modifier = Modifier.padding(bottom = 7.dp)
            )
            Text(
                text = "Texto con tamaño personalizado",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 7.dp)
            )
            Text(
                text = "Texto con tamaño personalizado",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 7.dp)
            )
            Text(
                text = "Texto en cursiva",
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(bottom = 7.dp)
            )

            Text(
                text = "Texto Subrayado",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(bottom = 7.dp)
            )
            Text(
                text = "Texto Centrado",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 7.dp)
            )
            HorizontalDivider(thickness = 2.dp)

            Text(
                text = "Texto Simple Azul",
                color = Color.Blue,
                modifier = Modifier.padding(bottom = 7.dp)
            )
        }
        item { botones() }
        }
        LazyRow {
        item { Text(text = "Amigdalisitis" , modifier = Modifier.padding(2.dp)) }
        item { Text(text = "Amigdalisitis") }
        }
    }

