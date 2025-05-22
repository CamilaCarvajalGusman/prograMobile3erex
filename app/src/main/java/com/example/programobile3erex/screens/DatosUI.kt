package com.example.programobile3erex.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.programobile3erex.viewmodels.MapViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun DatosUI(
    navController: NavController,
    page: String,
    sharedViewModel: MapViewModel = viewModel()
) {
    var showMap by remember { mutableStateOf(false) }
    val contentButton = if (showMap) "Ocultar Mapa" else "Mostrar Mapa"
    val listaPlanes = listOf("Plan Flex 5", "Plan Flex 8", "Plan FLEX 10")
    val pageEntero = page.toIntOrNull() ?: 0
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(10.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Donde enviaremos tu SIM",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp
                )
            }
            item {
                Text(
                    text = "Para el ${listaPlanes[pageEntero]}",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 25.sp
                )
            }
            item {
                OutlinedTextField(
                    value = sharedViewModel.phone.value,
                    onValueChange = { sharedViewModel.actualizarTelefono(it) },
                    label = { Text("Teléfono celular") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxSize()
                )
            }
            item {
                OutlinedTextField(
                    value = sharedViewModel.latitud.value?.toString() ?: "",
                    onValueChange = { },
                    label = { Text("Latitud") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    enabled = false,
                    modifier = Modifier.fillMaxSize()
                )
            }
            item {
                OutlinedTextField(
                    value = sharedViewModel.longitud.value?.toString() ?: "",
                    onValueChange = { },
                    label = { Text("Longitud") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    enabled = false,
                    modifier = Modifier.fillMaxSize()
                )
            }
            item {
                // Botón para mostrar el mapa

                Button(
                    onClick = {
                        showMap=!showMap
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(contentButton)
                }
            }
            if (showMap) {
                item {
                    Box(
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxSize()
                    ) {
                        GoogleMap(
                            modifier = Modifier.fillMaxSize(),
                            onMapClick = { latLng ->
                                sharedViewModel.actualizarUbicacion(latLng.latitude, latLng.longitude)
                            }
                        ) {
                            val latitude = sharedViewModel.latitud.value
                            val longitude = sharedViewModel.longitud.value
                            if (latitude != null && longitude != null) {
                                Marker(
                                    state = MarkerState(position = LatLng(latitude, longitude)),
                                    title = "Tu ubicación"
                                )
                            }
                        }
                    }
                }
            }
            item {
                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Enviando SIM a\nlat=${sharedViewModel.latitud.value} lng=${sharedViewModel.longitud.value} tel=${sharedViewModel.phone.value}",
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    enabled = sharedViewModel.esNumValido(),
                    modifier = Modifier.height(48.dp)
                ) {
                    Text("Enviar SIM")
                }
            }
        }
    }
}