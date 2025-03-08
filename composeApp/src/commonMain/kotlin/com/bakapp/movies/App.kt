package com.bakapp.movies

import androidx.compose.runtime.*
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.bakapp.movies.ui.screens.Navigation
import org.jetbrains.compose.ui.tooling.preview.Preview




@Composable
@Preview
fun App() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .crossfade(true)
            .logger(DebugLogger())
            .build()
         }
        Navigation()
    }

