package com.bangkit.liburun.detail

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bangkit.liburun.model.Wisata

@Composable
fun DetailScreen(wisata: Wisata){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState).fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(modifier = Modifier.fillMaxSize()) {
                    DetailHeader(wisata = wisata, containerHeight = this@BoxWithConstraints.maxHeight)
                    DetailContent(wisata = wisata)
                }
            }
        }
    }
}

@Composable
private fun DetailHeader(wisata: Wisata, containerHeight: Dp){
    AsyncImage(
        model = wisata.foto,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
    )
}

@Composable
private fun DetailContent(wisata: Wisata){
    Column {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wisata.nama, style = MaterialTheme.typography.titleLarge)
        }
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wisata.deskripsi, style = MaterialTheme.typography.titleSmall)
        }
    }
}