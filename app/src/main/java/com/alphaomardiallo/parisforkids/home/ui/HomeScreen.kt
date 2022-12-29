package com.alphaomardiallo.parisforkids.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import com.alphaomardiallo.parisforkids.home.presenter.HomeViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    ParisForKidsTheme {
        val eventState = homeViewModel.eventState
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
                .wrapContentSize(Alignment.Center)
        ) {
            HorizontalListOfEvents(list = eventState)
        }
    }
}