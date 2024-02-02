package dev.jay.flipacoin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.jay.flipacoin.ui.components.CoinFace
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class CoinViewModel @Inject constructor() : ViewModel() {
    private val _coinFace = mutableStateOf(CoinFace.Head)
    private val _headCount = mutableStateOf(0)
    private val _tailCount = mutableStateOf(0)
    private val _isFlipped = mutableStateOf(false)

    val coinFace: State<CoinFace> = _coinFace
    val headCount: State<Int> = _headCount
    val tailCount: State<Int> = _tailCount
    val isFlipped: State<Boolean> = _isFlipped

    fun flipCoin() {
        val result = Random.nextBoolean()
        _coinFace.value = if (result) CoinFace.Head else CoinFace.Tail

        when (_coinFace.value) {
            CoinFace.Head -> incrementHeadCount()
            CoinFace.Tail -> incrementTailCount()
        }

        _isFlipped.value = !_isFlipped.value
    }

    private fun incrementHeadCount() {
        _headCount.value++
    }

    private fun incrementTailCount() {
        _tailCount.value++
    }
}