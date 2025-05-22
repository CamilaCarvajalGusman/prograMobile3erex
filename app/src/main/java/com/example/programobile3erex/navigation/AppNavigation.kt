package com.example.programobile3erex.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.programobile3erex.screens.DatosUI
import com.example.programobile3erex.screens.HomeUI
import com.example.programobile3erex.viewmodels.MapViewModel


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
        composable(
            route = Screens.DatosUI.route + "/{page}",
            arguments = listOf(navArgument("page") { type = NavType.StringType })
        ) { backStackEntry ->
            val page = backStackEntry.arguments?.getString("page") ?: "Sin datos"
            val sharedViewModel: MapViewModel = viewModel() // Se obtiene la instancia compartida
            DatosUI(navController = navController, page = page, sharedViewModel = sharedViewModel)
        }
    }
}
