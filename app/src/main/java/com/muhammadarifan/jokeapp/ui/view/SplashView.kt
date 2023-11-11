package com.muhammadarifan.jokeapp.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.muhammadarifan.jokeapp.ui.navigation.AppRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

@Composable
fun SplashView(
    navController: NavController? = null
) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController?.navigate(AppRoutes.JOKE) {
            popUpTo(AppRoutes.SPLASH) {
                inclusive = true
            }
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme
            .colorScheme
            .background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Muhammad Arifan App")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Joke App")
        }
    }
}

@Composable
@Preview
fun SplashViewPreview() {
    SplashView()
}