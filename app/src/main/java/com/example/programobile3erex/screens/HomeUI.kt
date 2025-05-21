package com.example.programobile3erex.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.programobile3erex.R
import kotlinx.coroutines.launch


@Composable
fun HomeUI(navController: NavController) {
    val listaPlanes = listOf("Plan Flex 5", "Plan Flex 8", "Plan FLEX 10")
    val listaPreciosAntes= listOf("Antes $270/mes", "Antes $370/mes", "Antes $470/mes")
    val listaPreciosDespues =listOf("Ahora $199/mes", "Ahora $299/mes", "Antes $399/mes")
    val listaGigas=listOf("5GB","8GB","10GB")
    val pagerState = rememberPagerState(pageCount = { listaPlanes.size })
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp) // Agrega margen general
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Centrar los elementos
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Nuestros planes móviles",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            )
            Text(
                text = "La mejor cobertura, increíbles beneficios y un compromiso con el planeta.",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 25.sp
            )
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = listaPlanes[page],
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                    Text(
                        text = listaPreciosAntes[page],
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        style = TextStyle(textDecoration = TextDecoration.LineThrough)
                    )
                    Text(
                        text = listaPreciosDespues[page],
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                    Text(
                        text = listaGigas[page],
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp
                    )
                    //características de cada plan
                    Text(
                        text = "✓ Llamadas y SMS ilimitados",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "✓ Hotspot. Comparte tus datos",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                    Text(
                        text =  "✓ Redes Sociales ilimitadas",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "✓ Arma tu plan con más apps ilimitadas",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                    Text(
                        text =  "✓ CO2 negativo",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.rrss),
                        contentDescription = "Redes Sociales"
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly // Espaciado uniforme
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            if (pagerState.currentPage > 0) {
                                pagerState.scrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Fondo transparente
                ) {
                    Icon(imageVector =Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retroceder")
                }

                Button(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(pagerState.currentPage + 1)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Fondo transparente
                ) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Avanzar")
                }
            }
            Row(){
                Button(
                    onClick = { navController.navigate("datos") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("Quiero este plan")
                }
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW)
                        //mensaje a mi teléfono:
                        val url = "https://api.whatsapp.com/send?phone=+59177927405&text=" + Uri.encode("Hola, UCB mobile, preciso su ayuda")
                        intent.data = Uri.parse(url)
                        context.startActivity(intent)

                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Fondo transparente
                ) {
                    Image(
                        painter = painterResource(R.drawable.whatsapp),
                        contentDescription = "Whatsapp",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }
    }
}