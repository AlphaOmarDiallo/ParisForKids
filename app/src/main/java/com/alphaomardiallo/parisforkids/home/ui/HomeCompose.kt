package com.alphaomardiallo.parisforkids.home.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.ui.component.SmallSpacer
import com.alphaomardiallo.parisforkids.common.ui.component.UIEventCard
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import com.alphaomardiallo.parisforkids.common.ui.theme.Typography
import com.alphaomardiallo.parisforkids.home.domain.model.UiEventCard

@Composable
fun SectionTitle(title: String, modifier: Modifier) {
    Row(modifier.padding(vertical = dimensionResource(id = R.dimen.margin_medium)),
        horizontalArrangement = Arrangement.SpaceBetween,
        content = {
            Text(text = title, style = Typography.h1)
        }
    )
}

@Composable
fun HorizontalListOfEvents(list: List<UiEventCard>, context: Context) {
    Box(modifier = Modifier.fillMaxWidth()) {
        LazyRow {
            items(list) { event ->
                UIEventCard(modifier = Modifier, event = event, context = context)
                SmallSpacer()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventTagChip(tag: String, modifier: Modifier, backgroundColor: Color, contentColor: Color) {
    Chip(
        onClick = { /*TODO*/ },
        modifier = modifier.padding(2.dp),
        colors = ChipDefaults.chipColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        )
    ) {
        Text(text = tag, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun Preview() {
    ParisForKidsTheme() {
        SectionTitle(title = "A faire aujourd'hui", modifier = Modifier)
    }
}
