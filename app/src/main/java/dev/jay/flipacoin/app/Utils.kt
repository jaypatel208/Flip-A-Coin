package dev.jay.flipacoin.app

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.jay.flipacoin.R

object Utils {
    @Composable
    fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = color
            )
        }
    }

    fun playCoinTossSound(context: Context) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.coin_flip)
        mediaPlayer.start()
    }
}