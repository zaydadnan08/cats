package com.verkada.android.catpictures.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.verkada.android.catpictures.R
import com.verkada.android.catpictures.data.Picture


@Composable
fun EnlargedPicture(
    picture: Picture,
    isFav: State<Boolean>,
    onClickFavIcon: (Picture) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.333333f)
            .background(color = Color(picture.color.toColorInt()))
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.padding(24.dp),
            model = picture.urls.regular,
            contentDescription = null
        )

        val favIconId = when(isFav.value) {
            true -> R.drawable.fav_filled
            false -> R.drawable.fav_empty
        }

        Image(
            painter = painterResource(favIconId),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clickable {
                    onClickFavIcon(picture)
                }
        )
    }
}
