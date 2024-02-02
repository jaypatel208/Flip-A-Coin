package dev.jay.flipacoin.ui.components

import android.content.Context
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jay.flipacoin.R
import dev.jay.flipacoin.app.Utils
import dev.jay.flipacoin.ui.theme.PrimaryAppColor
import dev.jay.flipacoin.ui.theme.boldText
import dev.jay.flipacoin.ui.theme.normalBoldText
import dev.jay.flipacoin.ui.theme.normalText

@Composable
fun HeadsOrTailsTitle() {
    Text(text = stringResource(id = R.string.heads_or_tails), fontFamily = boldText, fontSize = 32.sp)
}

@Composable
fun FlipCoinInfo() {
    Text(
        text = stringResource(id = R.string.flip_coin_info),
        fontFamily = normalText,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 30.dp),
        color = Color.Gray
    )
}

@Composable
fun ValueIndicatorText(propertyName: String, propertyValue: Int) {
    Row {
        Text(text = "$propertyName: ", fontFamily = normalText)
        Text(
            text = "$propertyValue",
            fontFamily = normalBoldText
        )
    }
}

@Composable
fun FlipCoinButton(context: Context, onFlipButtonClick: () -> Unit) {
    Button(
        onClick = {
            onFlipButtonClick()
            Utils.playCoinTossSound(context)
        },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PrimaryAppColor)
    ) {
        Text(text = stringResource(id = R.string.flip_the_coin), color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun PlayInfoText() {
    Text(
        text = stringResource(id = R.string.touch_or_press),
        color = Color.Black,
        fontFamily = normalText,
        fontSize = 13.sp
    )
}

@Composable
fun Coin(context: Context, coinFace: CoinFace, onCoinClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.clickable(
            onClick = {
                onCoinClick()
                Utils.playCoinTossSound(context)
            },
            indication = null,
            interactionSource = interactionSource
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                drawCircle(
                    color = if (coinFace == CoinFace.Head) PrimaryAppColor else Color.Black,
                    center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                    radius = size.minDimension / 2
                )
            }
            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                val innerCircleRadius = (size.minDimension / 2) - 12.dp.toPx()

                drawCircle(
                    color = Color.White,
                    center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                    radius = innerCircleRadius,
                    style = Stroke(width = 6f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f))
                )
            }
        }
        Text(
            text = if (coinFace == CoinFace.Head) stringResource(id = R.string.heads_caps) else stringResource(id = R.string.tails_caps),
            fontFamily = boldText,
            color = Color.White,
            fontSize = 34.sp
        )
    }
}