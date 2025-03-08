package com.bakapp.movies.ui.screens.home


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bakapp.movies.Movie
import com.bakapp.movies.movies
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    //TODO: simulacion de la carga
    var state by mutableStateOf(UiState())
        private set
    init {
        viewModelScope.launch {
        state = UiState(loading = true)
            delay(1000)
            state = UiState(loading = false, movies = movies)
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )
}