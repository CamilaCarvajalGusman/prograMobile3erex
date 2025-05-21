package com.example.programobile3erex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.programobile3erex.screens.DatosUI
import com.example.programobile3erex.screens.HomeUI
import com.example.programobile3erex.screens.MapUI

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.HomeUI.route
    ){
        composable(Screens.HomeUI.route)    {
            HomeUI(navController)
        }
        composable(Screens.DatosUI.route + "/{page}") { backStackEntry ->
            val page = backStackEntry.arguments?.getString("page") ?: "Sin datos"
            DatosUI(navController, page)
        }

        composable(Screens.MapUI.route)    {
            MapUI(navController)
        }
    }
}
