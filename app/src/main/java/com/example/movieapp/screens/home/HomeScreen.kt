package com.example.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.R
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.widgets.MovieRow
import com.example.movieapp.widgets.MovieTopAppBar

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        MovieTopAppBar(title = stringResource(id = R.string.title),
            backgroundColor = Color.Red)
    }) {
        MainContent(navController = navController)
    }
}


@Composable
private fun MainContent(navController: NavController, movies: List<Movie> = getMovies()) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movies) {
                MovieRow(movie = it ) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/${movie.id}" )
                }
            }
        }
    }
}