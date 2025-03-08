package com.bakapp.movies.ui.screens.home


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bakapp.movies.data.Movie
import com.bakapp.movies.data.MoviesService
import com.bakapp.movies.data.RemoteMovie
import com.bakapp.movies.data.movies
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(
    private val moviesService: MoviesService
) : ViewModel() {

    //TODO: simulacion de la carga
    var state by mutableStateOf(UiState())
        private set
    init {
        viewModelScope.launch {
        state = UiState(loading = true)

            state = UiState(
                loading = false,
                movies = moviesService.fetchPopularMovies().results.map {
                    it.toDomainMovie()
                }
            )
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )
}

private fun RemoteMovie.toDomainMovie() = Movie(
    id = id,
    title = title,
    poster = "https:image.tmdb.org/t/p/w500$posterPath"
)