package com.example.programobile3erex.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.programobile3erex.R
import kotlinx.coroutines.launch

@Composable
fun HomeUI(navController: NavController) {
    val listaPlanes = listOf("Plan Flex 5", "Plan Flex 8", "Plan FLEX 10")
    val listaPreciosAntes = listOf("270", "370", "470")
    val listaPreciosDespues = listOf("199", "299", "399")
    val listaGigas = listOf("5GB", "8GB", "10GB")
    val pagerState = rememberPagerState(pageCount = { listaPlanes.size })
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Nuestros planes móviles",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                textAlign = TextAlign.Center,
                fontSize = 35.sp,
                modifier = Modifier.fillMaxSize().padding(top = 40.dp)
            )
        }
        item {
            Text(
                text = "La mejor cobertura, increíbles beneficios y un compromiso con el planeta.",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp // Ajusta el interlineado
                ),
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 15.sp
            )
        }
        item {
            HorizontalPager(state = pagerState) { page ->
                Box(
                    modifier = Modifier.background(Color.White).padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 2.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(16.dp),
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
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = buildAnnotatedString {
                                append("Antes ")
                                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                                    append("$${listaPreciosAntes[page]}")
                                }
                                append("/mes")
                            },
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "Ahora ${listaPreciosDespues[page]}/mes",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                        Text(
                            text = listaGigas[page],
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp
                        )
                        listOf(
                            "✓ Llamadas y SMS ilimitados",
                            "✓ Hotspot. Comparte tus datos",
                            "✓ Redes Sociales ilimitadas",
                            "✓ Arma tu plan con más apps ilimitadas",
                            "✓ CO2 negativo"
                        ).forEach { feature ->
                            Text(
                                text = feature,
                                style = MaterialTheme.typography.headlineMedium,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontSize = 15.sp
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.rrss),
                            contentDescription = "Redes Sociales"
                        )
                    }
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
                    onClick = {navController.navigate("datos/${pagerState.currentPage}")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(0.7f)
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