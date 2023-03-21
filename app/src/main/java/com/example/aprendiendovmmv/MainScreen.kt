package com.example.aprendiendovmmv

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.random.Random


class DiceViewModel: ViewModel() {
    private var _numero by mutableStateOf(0)
    val numero get() = _numero

    fun changeNumber(){
        _numero = Random.nextInt(from = 1, until = 7)
    }
}


@Composable
fun MainScreen() {

val viewModel: DiceViewModel = viewModel()

    DiceLauncher(viewModel.numero/*getter*/, {viewModel.changeNumber()}/*setter*/)

}

@Composable
fun DiceLauncher(numero: Int, changeNumber: ()-> Unit) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedButton(onClick = changeNumber ) {
            Text(text = "Tirar dado")
        }
        Text(text = numero.toString(), fontSize = 80.sp)
    }}
