package com.alphaomardiallo.parisforkids.common.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.text.parseAsHtml
import coil.compose.AsyncImage
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.ui.theme.Typography
import com.alphaomardiallo.parisforkids.home.domain.UiEventCard
import com.alphaomardiallo.parisforkids.home.ui.EventTagChip

@Composable
fun UIEventCard(modifier: Modifier, event: UiEventCard) {
    Card(
        modifier = modifier
            .width(dimensionResource(id = R.dimen.card_width_normal))
            .height(dimensionResource(id = R.dimen.card_height_normal))
            .clickable { /*TODO*/ },
        shape = MaterialTheme.shapes.medium,
        contentColor = MaterialTheme.colors.onPrimary,
        elevation = dimensionResource(id = R.dimen.elevation_normal)
    ) {
        val gradient = Brush.verticalGradient(
            colors = listOf(Color.Transparent, Color.Black),
            startY = 0f,
            endY = 450f
        )

        AsyncImage(
            model = event.coverImage,
            contentDescription = event.coverCredit,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(brush = gradient)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.margin_small)),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth(0.9f),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        event.tags?.map {
                            EventTagChip(tag = stringResource(id = it!!.name), modifier = modifier, backgroundColor = it!!.backgroundColor, contentColor = it!!.contentColor)
                            Spacer(modifier.size(dimensionResource(id = R.dimen.margin_small)))
                        }
                    }
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Icon heart")
                }
                Spacer(modifier.size(dimensionResource(id = R.dimen.margin_medium)))
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = modifier.fillMaxSize()
                ) {
                    Text(text = event.title!!, style = Typography.h3)
                    Spacer(modifier.size(dimensionResource(id = R.dimen.margin_medium)))
                    Text(
                        text = event.leadText!!,
                        style = Typography.h4,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier.size(dimensionResource(id = R.dimen.margin_small)))
                    Text(text = event.audience!!, style = Typography.body1)
                    Spacer(modifier.size(dimensionResource(id = R.dimen.margin_small)))
                    Text(
                        text = "${event.dateDescription?.parseAsHtml()}  -  ${event.zipcode}  -  ${event.priceType}",
                        style = Typography.body2
                    )
                }
            }
        }

    }
}