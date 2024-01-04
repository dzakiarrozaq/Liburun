package com.bangkit.liburun

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.bangkit.liburun.model.WisataData
import com.bangkit.liburun.model.Wisata

@Composable
fun WisataHomeContent(navigateToDetail: (Wisata) -> Unit){
    val wisata = remember {
        WisataData.wisata
    }
    LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 64.dp) ){
        items(
            items = wisata,
            itemContent = {
                WisataList(wisata = it, navigateToDetail)
            }
        )
    }
}