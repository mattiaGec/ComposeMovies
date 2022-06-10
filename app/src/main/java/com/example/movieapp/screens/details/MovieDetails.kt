package com.example.movieapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow
import com.example.movieapp.widgets.MovieTopAppBar

@Preview
@Composable
fun MovieDetails(
    navController: NavController = NavController(LocalContext.current),
    movieId: String? = getMovies()[0].id
) {
    getMovies().find { it.id == movieId }?.let { movie ->
        Scaffold(topBar = {
            MovieTopAppBar(
                title = movie.title,
                onBackPressed = { navController.popBackStack() },
                backgroundColor = Color.Red
            )
        }) {
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MovieRow(movie = movie)
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Text(text = "Movie Images")
                    LazyRow {
                        items(items = movie.images) { img ->
                            Card(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(240.dp),
                                elevation = 5.dp
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(model = img),
                                    contentDescription = "Movie Image",
                                    Modifier.fillMaxSize().height(300.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}