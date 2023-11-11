package com.muhammadarifan.jokeapp.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.muhammadarifan.jokeapp.ui.viewmodel.JokeViewModel
import com.muhammadarifan.jokeapp.util.ResourceState

@Composable
fun JokeView(
    navController: NavController? = null,
    jokeViewModel: JokeViewModel = hiltViewModel()
) {
    val jokeState = jokeViewModel.joke.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme
            .colorScheme
            .background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            when (jokeState.value) {
                is ResourceState.Error -> {
                    Text(
                        text = (jokeState.value as ResourceState.Error).message,
                        color = MaterialTheme
                            .colorScheme
                            .error,
                        textAlign = TextAlign.Center
                    )
                }
                is ResourceState.Loading -> {
                    Text(
                        text = "Waiting for joke...",
                        color = Color.Gray,
                    )
                }
                is ResourceState.Success -> {
                    Text(
                        text = '"' + (jokeState.value as ResourceState.Success).data[0].joke + '"',
                        color = MaterialTheme
                            .colorScheme
                            .primary,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    jokeViewModel.getJokes(1)
                },
                enabled = (jokeState.value !is ResourceState.Loading)
            ) {
                when (jokeState.value) {
                    is ResourceState.Loading -> {
                        Text(text = "Loading...")
                    }
                    else -> {
                        Text(text = "Generate Joke")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun JokeViewPreview() {
    JokeView()
}