package com.example.programobile3erex.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.maps.android.compose.GoogleMap

@Composable
fun MapUI(navController: NavController){
    //val marker = LatLng(28.270833, -16.63916)
    GoogleMap(modifier = Modifier.fillMaxSize()) {
        //Marker(state = marker)
    }
}