package com.alphaomardiallo.parisforkids.home.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.ui.component.MediumSpacer
import com.alphaomardiallo.parisforkids.common.ui.component.SmallSpacer
import com.alphaomardiallo.parisforkids.common.ui.component.UIEventCard
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import com.alphaomardiallo.parisforkids.common.ui.theme.Typography
import com.alphaomardiallo.parisforkids.home.domain.model.UiEventCard
import com.alphaomardiallo.parisforkids.home.domain.model.UiMeteo
import com.google.android.material.chip.Chip

@Composable
fun SectionTitle(title: String, modifier: Modifier) {
    Row(modifier.padding(vertical = dimensionResource(id = R.dimen.margin_medium)),
        horizontalArrangement = Arrangement.SpaceBetween,
        content = {
            Text(text = title, style = Typography.titleLarge)
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

@Composable
fun EventTagChip(tag: String, modifier: Modifier, backgroundColor: Color, contentColor: Color) {
    ElevatedAssistChip(
        onClick = { /*TODO*/ },
        modifier = modifier.padding(2.dp),
        label = {Text(text = tag, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)}
        /*colors = Chip.ChipColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        )*/
    )
}

@Preview
@Composable
fun MeteoCard() {
    val list = mutableListOf(
        UiMeteo(R.drawable.ic_sunny, 20, "Mon"),
        UiMeteo(R.drawable.ic_sunny, 22, "Tue"),
        UiMeteo(R.drawable.ic_sunny, 25, "Wed"),
        UiMeteo(R.drawable.ic_sunny, 23, "Thu"),
        UiMeteo(R.drawable.ic_sunny, 26, "Fri"),
    )
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "18°C", color = Color.Black, style = MaterialTheme.typography.displayLarge)
                Image(
                    painter = painterResource(id = R.drawable.ic_sunny),
                    contentDescription = "sunny"
                )
            }
            MediumSpacer()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                list.forEach { meteo ->
                    Card {
                        Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(painter = painterResource(id = meteo.icon), contentDescription = "")
                            Text(text = meteo.temp.toString())
                            Text(text = meteo.day)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    ParisForKidsTheme {
        SectionTitle(title = "A faire aujourd'hui", modifier = Modifier)
    }
}
