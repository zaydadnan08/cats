package com.verkada.android.catpictures

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.verkada.android.catpictures.ui.EnlargedPicture
import com.verkada.android.catpictures.ui.SinglePictureInGrid

@Composable
fun PictureView(screen: Screens, viewModel: MainComposeViewModel) {
    val page = viewModel.page.value;
    val loading = viewModel.loading.value;

    val favorites = viewModel.favorites;

    //Setting pictures to show based on screen type
    val pictures = if (screen == Screens.Home) viewModel.pictures else favorites
    var selectedPicture by remember { mutableStateOf(-1) }

    Column {
        if (selectedPicture != -1) {
            EnlargedPicture(
                picture = pictures[selectedPicture],
                isFav = favorites.contains(pictures[selectedPicture]),
                onClickFavIcon = {
                    viewModel.updateFavorites(pictures[selectedPicture])
                    //if user deselects picture in Favourites, set enlarged picture to last picture in favorites
                    if (screen == Screens.Favorites) {
                        selectedPicture = pictures.size - 1;
                    }
                }
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(1.dp)
        ) {
            itemsIndexed(items = pictures) { index, item ->
                viewModel.onChangeHomeScrollPosition(index)
                if ((index + 1) >= (page * PAGE_SIZE) && !loading) {
                    viewModel.nextPage()
                }
                SinglePictureInGrid(
                    index = index,
                    picture = item,
                    highlighted = index == selectedPicture,
                    onClick = {
                        selectedPicture = if (selectedPicture === index) -1 else index;
                    })
            }
        }
    }
}
