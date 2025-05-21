package com.example.programobile3erex.screens

import android.app.Activity
import android.content.pm.PackageManager
import android.telephony.SmsManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import android.Manifest
import android.content.Context
import androidx.compose.ui.platform.LocalContext

@Composable
fun DatosUI(navController: NavController, page: String) {
    var telefono by remember { mutableStateOf("+591") }
    var latitud by remember { mutableStateOf("") }
    var longitud by remember { mutableStateOf("") }
    val listaPlanes = listOf("Plan Flex 5", "Plan Flex 8", "Plan FLEX 10")
    val context = LocalContext.current
    val pageEntero=page.toIntOrNull()?:0
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                enviarSMS(context, telefono, "Mensaje de prueba desde la app")
            } else {
                println("Permiso denegado")
            }
        }
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Centrar los elementos
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Ingrese sus datos",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            )
            Text(
                text = "Para el plan: ${listaPlanes[pageEntero]}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "Para enviarle un SIM",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 25.sp
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = longitud,
                onValueChange = { longitud = it },
                label = { Text("Longitud") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                   // navController.navigate("mapa")
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED
                    ) {
                        enviarSMS(context, telefono, "Mensaje de prueba desde la app")
                    } else {
                        requestPermissionLauncher.launch(Manifest.permission.SEND_SMS)
                    }

                }
            ) {
                Text("Continuar")
            }
        }
    }
}
fun enviarSMS(context: Context, numero: String, mensaje: String) {
    try {
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(numero, null, mensaje, null, null)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

