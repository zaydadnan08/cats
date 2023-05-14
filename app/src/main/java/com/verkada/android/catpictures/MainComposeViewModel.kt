package com.verkada.android.catpictures

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verkada.android.catpictures.data.Picture
import com.verkada.android.catpictures.network.Network
import kotlinx.coroutines.launch

const val PAGE_SIZE = 30;

class MainComposeViewModel : ViewModel() {
    val pictures = mutableStateListOf<Picture>()
    val favorites = mutableStateListOf<Picture>()

    val page = mutableStateOf(1);
    val loading = mutableStateOf(false)

    private var homeListScrollPosition = 0

    init {
        viewModelScope.launch {
            loading.value = true
            pictures.addAll(Network.service.pictures(page = page.value, perPage = PAGE_SIZE))
            loading.value = false
        }
    }

    fun nextPage() {
        viewModelScope.launch {
            // prevent duplicate event due to recompose happening to quickly
            if ((homeListScrollPosition + 1) >= (page.value * PAGE_SIZE)) {
                loading.value = true
                page.value += 1;

                if (page.value > 1) {
                    val result = Network.service.pictures(page = page.value, perPage = PAGE_SIZE)
                    pictures.addAll(result)
                }
                loading.value = false
            }
        }
    }

    fun updateFavorites(pic: Picture) {
        if (favorites.contains(pic)) {
            favorites.remove(pic)
        } else {
            favorites.add(pic)
        }
    }

    fun onChangeHomeScrollPosition(position: Int) {
        homeListScrollPosition = position
    }
}
