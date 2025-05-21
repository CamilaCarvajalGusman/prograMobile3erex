package com.example.programobile3erex.navigation

sealed class Screens (val route: String){
    object HomeUI:Screens("inicio")
    object DatosUI:Screens("datos")
    object MapUI:Screens("mapa")
}