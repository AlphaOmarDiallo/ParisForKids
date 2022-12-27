package com.alphaomardiallo.parisforkids.home.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alphaomardiallo.parisforkids.common.ui.component.SmallSpacer
import com.alphaomardiallo.parisforkids.common.ui.component.UIEventCard
import com.alphaomardiallo.parisforkids.home.domain.UiEventCard

@Composable
fun HorizontalListOfEvents(list: List<UiEventCard>) {
    Box(modifier = Modifier.fillMaxWidth()) {
        LazyRow {
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