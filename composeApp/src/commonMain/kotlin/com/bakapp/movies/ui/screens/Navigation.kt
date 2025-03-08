package com.bakapp.movies.ui.screens

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bakapp.movies.movies
import com.bakapp.movies.ui.screens.detail.DetailScreen
import com.bakapp.movies.ui.screens.home.HomeScreen


@Composable
fun Navigation(modifier: Modifier = Modifier) {
    var navController = rememberNavController()
    NavHost( navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(
                onMivieClick = {movie -> navController.navigate("details/${movie.id}") }
            )
        }
        composable("details/{movieId}",
            arguments = listOf( navArgument("movieId"){type= NavType.IntType})
        ){backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")
            DetailScreen(
                movie = movies.first { it.id == movieId },
                onBack = { navController.popBackStack()}
            )
        }

    }
}