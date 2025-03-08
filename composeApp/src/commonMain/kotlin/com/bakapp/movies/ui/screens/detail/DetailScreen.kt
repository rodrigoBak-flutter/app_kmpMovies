package com.bakapp.movies.ui.screens.detail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.bakapp.movies.movies
import com.bakapp.movies.ui.screens.Screen
import kmpmovie.composeapp.generated.resources.Res
import kmpmovie.composeapp.generated.resources.back
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(){
    val movie = movies[0]
    Screen {
        Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(movie.title)},
                        navigationIcon = {
                            IconButton(
                                onClick = {}
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

        }

    }
}





