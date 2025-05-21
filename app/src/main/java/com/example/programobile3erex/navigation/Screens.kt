package com.example.programobile3erex.navigation

sealed class Screens (val route: String){
    object HomeUI:Screens("inicio")
    object MapUI:Screens("mapa")
}