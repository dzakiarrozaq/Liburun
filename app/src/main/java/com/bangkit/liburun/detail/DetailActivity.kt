package com.bangkit.liburun.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bangkit.liburun.model.Wisata
import com.bangkit.liburun.ui.theme.LiburunTheme

class DetailActivity : ComponentActivity() {
    private val wisata: Wisata by lazy { intent?.getSerializableExtra(WISATA_ID) as Wisata }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiburunTheme {
                DetailScreen(wisata = wisata)
            }
        }
    }

    companion object{
        private const val WISATA_ID = "wisata_id"
        fun newIntent(context: Context, wisata: Wisata)= Intent(context, DetailActivity::class.java).apply {
            putExtra(WISATA_ID, wisata)
        }
    }
}