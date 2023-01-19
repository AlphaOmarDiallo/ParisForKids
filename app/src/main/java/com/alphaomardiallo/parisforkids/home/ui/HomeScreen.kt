package com.alphaomardiallo.parisforkids.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.ui.component.MediumSpacer
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import com.alphaomardiallo.parisforkids.common.ui.theme.blackOverlay
import com.alphaomardiallo.parisforkids.home.domain.UiEventCard
import com.alphaomardiallo.parisforkids.home.presenter.HomeViewModel
import kotlinx.coroutines.CoroutineScope

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    coroutineScope: CoroutineScope
) {
    ParisForKidsTheme {
        val eventState = homeViewModel.eventState
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = blackOverlay)
                .wrapContentSize(Alignment.Center)
                .padding(horizontal = dimensionResource(id = R.dimen.margin_small))
                .verticalScroll(rememberScrollState()),
            content = {
                HomeContent(eventState, modifier = Modifier)
            }
        )
    }
}

@Composable
private fun HomeContent(eventState: List<UiEventCard>, modifier: Modifier) {
    val context = LocalContext.current
    SectionTitle(
        title = stringResource(id = R.string.home_title_section_to_do_today),
        modifier = modifier
    )
    MediumSpacer()
    HorizontalListOfEvents(list = eventState, context = context)
    SectionTitle(
        title = stringResource(id = R.string.home_title_section_to_this_weekend),
        modifier = modifier
    )
    MediumSpacer()
    HorizontalListOfEvents(list = eventState, context = context)
    SectionTitle(
        title = stringResource(id = R.string.home_title_section_to_do_this_week),
        modifier = modifier
    )
    MediumSpacer()
    HorizontalListOfEvents(list = eventState, context = context)
    SectionTitle(
        title = stringResource(id = R.string.home_title_section_by_theme),
        modifier = modifier
    )
    MediumSpacer()
    HorizontalListOfEvents(list = eventState, context = context)
}
