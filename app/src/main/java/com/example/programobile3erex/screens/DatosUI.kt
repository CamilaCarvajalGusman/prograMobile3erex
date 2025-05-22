package com.example.programobile3erex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext

@Composable
fun DatosUI(navController: NavController, page: String) {
    var telefono by remember { mutableStateOf("+591") }
    var latitud by remember { mutableStateOf("") }
    var longitud by remember { mutableStateOf("") }
    val listaPlanes = listOf("Plan Flex 5", "Plan Flex 8", "Plan FLEX 10")
    val context = LocalContext.current
    val pageEntero=page.toIntOrNull()?:0
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.Gray)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Centrar los elementos
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Donde enviaremos tu SIM",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            )
            Text(
                text = "Para el ${listaPlanes[pageEntero]}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = telefono,
                onValueChange = {
                    if (it.startsWith("+591")) {
                    telefono = it
                } },

                label = { Text("Teléfono celular") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = latitud,
                onValueChange = { latitud = it },
                label = { Text("Latitud") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                enabled=false
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = longitud,
                onValueChange = { longitud = it },
                label = { Text("Longitud") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                enabled=false
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate("mapa")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text("Seleccionar ubicación")
            }
        }
    }
}

