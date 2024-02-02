package dev.jay.flipacoin.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import dev.jay.flipacoin.app.Utils
import dev.jay.flipacoin.ui.theme.FlipACoinTheme
import dev.jay.flipacoin.ui.theme.PrimaryAppColor
import dev.jay.flipacoin.view.screens.HomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlipACoinTheme {
                Utils.SetBarColor(color = PrimaryAppColor)
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    HomeScreen()
                }
            }
        }
    }
}
