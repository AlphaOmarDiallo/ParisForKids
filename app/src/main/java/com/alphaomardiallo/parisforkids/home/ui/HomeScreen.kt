package com.alphaomardiallo.parisforkids.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.parisforkids.common.ui.component.SmallSpacer
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import com.alphaomardiallo.parisforkids.home.domain.UiEventCard
import com.alphaomardiallo.parisforkids.home.presenter.HomeViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    ParisForKidsTheme {
        val allEvents = homeViewModel.allEventsAsUIEventCard.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
                .wrapContentSize(Alignment.Center)
        ) {
            HorizontalListOfEvents(list = allEvents)
        }
    }
}

@Composable
fun HorizontalListOfEvents(list: List<UiEventCard>) {
    Box(modifier = Modifier.fillMaxWidth()) {
        LazyRow() {
            items(list) { event ->
                SmallSpacer()
                UIEventCard(modifier = Modifier, event = event)
                SmallSpacer()
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventTagChip(tag: String, modifier: Modifier) {
    Chip(
        onClick = { /*TODO*/ },
        modifier = modifier.padding(2.dp),
        colors = ChipDefaults.chipColors(backgroundColor = Color.Black, contentColor = Color.White)
    ) {
        Text(text = tag, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}