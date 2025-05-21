package com.example.programobile3erex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.programobile3erex.R

@Composable
fun HomeUI(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()

    ){

            Text(
                text = "Nuestros planes móviles",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF004D40),
                textAlign = TextAlign.Center
            )
            Text(
                text = "La mejor cobertura, increíbles beneficios y un compromiso con el planeta.",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
        Image(
            painter = painterResource(id = R.drawable.rrss),
            contentDescription = "Imagen de ejemplo",
            modifier = Modifier.fillMaxSize()
        )
        Button(
            onClick = { navController.navigate("mapa") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Quiero este plan")
        }

    }
}