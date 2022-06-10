package com.example.movieapp.widgets

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MovieTopAppBar(
    title: String = "title",
    onBackPressed: (() -> Unit)? = null,
    backgroundColor: Color = Color.Red
) {
    TopAppBar(title = {
        Text(text = title)
    }, navigationIcon = {
        onBackPressed?.let {
            Icon(modifier = Modifier.clickable {
                  onBackPressed.invoke()
            }, imageVector = Icons.Default.ArrowBack, contentDescription = "Icon Back")
        }
    },
        backgroundColor = backgroundColor
    )
}