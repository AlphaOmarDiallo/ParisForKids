package com.alphaomardiallo.parisforkids.common.ui.component

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.text.parseAsHtml
import coil.compose.AsyncImage
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.domain.util.district.formatDistrict
import com.alphaomardiallo.parisforkids.common.ui.theme.Typography
import com.alphaomardiallo.parisforkids.home.domain.model.UiEventCard
import com.alphaomardiallo.parisforkids.home.ui.EventTagChip

@Composable
fun UIEventCard(modifier: Modifier, event: UiEventCard, context: Context) {
    Card(
        modifier = modifier
            .width(dimensionResource(id = R.dimen.card_width_normal))
            .height(dimensionResource(id = R.dimen.card_height_normal))
            .clickable { /*TODO*/ },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.onPrimary),
    ) {
        val gradient = overlay()
        EventImage(event, modifier)
        CardContent(modifier, gradient, event, context)
    }
}

@Composable
private fun overlay(): Brush {
    return Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black),
        startY = 0f,
        endY = 450f
    )
}

@Composable
private fun EventImage(
    event: UiEventCard,
    modifier: Modifier
) {
    AsyncImage(
        model = event.coverImage,
        contentDescription = event.coverCredit,
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
private fun CardContent(
    modifier: Modifier,
    gradient: Brush,
    event: UiEventCard,
    context: Context
) {
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
            EventCardTopPart(modifier, event, context)
            Spacer(modifier.size(dimensionResource(id = R.dimen.margin_small)))
            EventCardBottomPart(modifier, event)
        }
    }
}

@Composable
private fun EventCardTopPart(
    modifier: Modifier,
    event: UiEventCard,
    context: Context
) {
    Column(content = {
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
                if (!event.tags.isNullOrEmpty()) {
                    event.tags!!.map {
                        if (it != null) {
                            EventTagChip(
                                tag = stringResource(id = it.name),
                                modifier = modifier,
                                backgroundColor = it.backgroundColor,
                                contentColor = it.contentColor
                            )
                            Spacer(modifier.size(dimensionResource(id = R.dimen.margin_x_small)))
                        }
                    }
                }
            }
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = stringResource(id = R.string.icon_content_description_heart)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            content = {
                SmallSpacer()

                PriceType(event.priceType)

                IsPrm(event.prm)

                IsDeaf(event.deaf)

                IsBlind(event.blind)

                District(event, context)
            })
    })
}

@Composable
private fun EventCardBottomPart(
    modifier: Modifier,
    event: UiEventCard
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = event.title!!, style = Typography.titleMedium)
        Spacer(modifier.size(dimensionResource(id = R.dimen.margin_small)))
        if (event.leadText != null) {
            Text(
                text = event.leadText!!,
                style = Typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier.size(dimensionResource(id = R.dimen.margin_small)))
        }
        if (event.dateDescription != null) {
            Text(
                text = "${event.dateDescription?.parseAsHtml()}",
                style = Typography.bodySmall,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun District(
    event: UiEventCard,
    context: Context
) {
    MediumSpacer()
    if (event.zipcode != null) {
        val zipcode = formatDistrict(event.zipcode, context)
        if (zipcode != null) {
            Text(
                text = stringResource(id = zipcode.displayName),
                style = Typography.titleSmall
            )
        }
    }
}

@Composable
private fun PriceType(priceType: String?) {
    if (priceType != null) {

        val icon = if (priceType == stringResource(id = R.string.not_free)) {
            painterResource(id = R.drawable.ic_attach_money)
        } else {
            painterResource(id = R.drawable.baseline_money_off_24)
        }

        Icon(
            painter = icon,
            contentDescription = null
        )
        MediumSpacer()
    }
}

@Composable
private fun IsPrm(prm: Boolean) {
    if (prm) {
        ShowIcon(
            icon = painterResource(id = R.drawable.ic_accessible),
            contentDescription = R.string.icon_content_description_prm
        )
        MediumSpacer()
    }
}

@Composable
private fun IsDeaf(deaf: Boolean) {
    if (deaf) {
        ShowIcon(
            icon = painterResource(id = R.drawable.ic_hearing),
            contentDescription = R.string.icon_content_description_deaf
        )
        MediumSpacer()
    }
}

@Composable
private fun IsBlind(blind: Boolean) {
    if (blind) {
        ShowIcon(
            icon = painterResource(id = R.drawable.ic_visibility),
            contentDescription = R.string.icon_content_description_blind
        )
    }
}

@Composable
private fun ShowIcon(icon: Painter, contentDescription: Int) {
    Icon(
        painter = icon,
        contentDescription = stringResource(id = contentDescription)
    )
}
