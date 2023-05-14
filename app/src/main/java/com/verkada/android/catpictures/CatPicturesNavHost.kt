package com.verkada.android.catpictures

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun CatPicturesNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val viewModel = viewModel<MainComposeViewModel>()
    NavHost(
        navController = navController,
        startDestination = Screens.Home.name,
        modifier = modifier
    ) {
        composable(route = Screens.Home.name) {
            PictureView(Screens.Home, viewModel)
        }

        composable(route = Screens.Favorites.name) {
            PictureView(Screens.Favorites, viewModel)
        }
    }
}

enum class Screens {
    Home,
    Favorites
}
