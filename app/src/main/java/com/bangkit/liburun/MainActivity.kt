package com.bangkit.liburun

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.bangkit.liburun.detail.DetailActivity
import com.bangkit.liburun.model.Wisata
import com.bangkit.liburun.ui.theme.LiburunTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiburunTheme {
                MyApp{
                    startActivity(DetailActivity.newIntent(this, it))
                }
            }

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(navigateToDetail: (Wisata) -> Unit){
    Scaffold (
        content = {
            WisataHomeContent(navigateToDetail = navigateToDetail)
            OptionMenu()
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionMenu(){
    val context = LocalContext.current

    TopAppBar(
        title = { Text(text = "LibuRun") },
        actions = {
            IconButton(onClick = { context.startActivity(Intent(context, AboutActivity::class.java)) }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "About_page")
            }
        })


}

