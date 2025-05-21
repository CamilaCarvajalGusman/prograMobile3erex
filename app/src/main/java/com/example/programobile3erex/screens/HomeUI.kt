package com.example.programobile3erex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeUI(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFB2EBF2), Color(0xFFE0F7FA))
                )
            )
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

    }
}