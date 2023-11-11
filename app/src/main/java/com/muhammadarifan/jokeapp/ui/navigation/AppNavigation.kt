package com.muhammadarifan.jokeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.muhammadarifan.jokeapp.ui.view.JokeView
import com.muhammadarifan.jokeapp.ui.view.SplashView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppRoutes.SPLASH) {
        composable(AppRoutes.SPLASH) {
            SplashView(navController = navController)
        }

        composable(AppRoutes.JOKE) {
            JokeView(navController = navController)
        }
    }
}