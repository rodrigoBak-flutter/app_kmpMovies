package com.bakapp.movies.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.bakapp.movies.data.Movie
import com.bakapp.movies.ui.screens.Screen
import kmpmovie.composeapp.generated.resources.Res
import kmpmovie.composeapp.generated.resources.back
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(movie: Movie, onBack: ()->Unit){

    Screen {
        Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(movie.title)},
                        navigationIcon = {
                            IconButton(
                                onClick = onBack
                            ){
                                Icon(
                                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                    contentDescription = stringResource(Res.string.back)
                                    )
                            }
                        }
                    )
                }

        ){
            Column {
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
            }
        }

    }
}





