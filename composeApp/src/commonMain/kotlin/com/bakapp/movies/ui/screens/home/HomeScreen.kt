package com.bakapp.movies.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.bakapp.movies.Movie
import com.bakapp.movies.movies
import com.bakapp.movies.ui.screens.Screen
import kmpmovie.composeapp.generated.resources.Res
import kmpmovie.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onMivieClick: (Movie) -> Unit){
    Screen {
        // val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(Res.string.app_name)) },
                    scrollBehavior = scrollBehavior
                )
            },
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
                padding ->
            LazyVerticalGrid(
                columns = GridCells.Adaptive(120.dp),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(padding)
            ){
                items(movies, key = {it.id}){
                    MovieItem(movie = it, onClick = {onMivieClick(it)})
                }
            }
        }

    }
}

@Composable
fun MovieItem(movie: Movie,onClick: () -> Unit ) {
    Column(
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        /*
        Box(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(2/3f)
        .clip(MaterialTheme.shapes.small)
        .background(MaterialTheme.colorScheme.primaryContainer)
        */
        AsyncImage(
            model =  movie.poster,
            contentDescription =  movie.title,
            contentScale =  ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2/3f)
                .clip(
                    MaterialTheme.shapes.small
                )

        )
        Text(
            movie.title,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            modifier = Modifier.padding(8.dp)
        )
    }
}
