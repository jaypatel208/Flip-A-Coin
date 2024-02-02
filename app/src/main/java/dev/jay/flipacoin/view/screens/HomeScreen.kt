package dev.jay.flipacoin.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.jay.flipacoin.R
import dev.jay.flipacoin.ui.components.Coin
import dev.jay.flipacoin.ui.components.FlipCoinButton
import dev.jay.flipacoin.ui.components.FlipCoinInfo
import dev.jay.flipacoin.ui.components.HeadsOrTailsTitle
import dev.jay.flipacoin.ui.components.PlayInfoText
import dev.jay.flipacoin.ui.components.ValueIndicatorText
import dev.jay.flipacoin.viewmodel.CoinViewModel

@Composable
fun HomeScreen(coinViewModel: CoinViewModel = hiltViewModel()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp)
    ) {
        val context = LocalContext.current
        HeadsOrTailsTitle()
        Spacer(modifier = Modifier.height(26.dp))
        FlipCoinInfo()
        Spacer(modifier = Modifier.height(45.dp))
        Row {
            ValueIndicatorText(
                propertyName = stringResource(id = R.string.heads),
                propertyValue = coinViewModel.headCount.value
            )
            Spacer(modifier = Modifier.width(24.dp))
            ValueIndicatorText(
                propertyName = stringResource(id = R.string.tails),
                propertyValue = coinViewModel.tailCount.value
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Coin(coinFace = coinViewModel.coinFace.value, onCoinClick = { coinViewModel.flipCoin() }, context = context)
        Spacer(modifier = Modifier.height(40.dp))
        FlipCoinButton(context = context) {
            coinViewModel.flipCoin()
        }
        Spacer(modifier = Modifier.height(50.dp))
        PlayInfoText()
    }
}