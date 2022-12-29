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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.ui.component.MediumSpacer
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import com.alphaomardiallo.parisforkids.common.ui.theme.blackOverlay
import com.alphaomardiallo.parisforkids.home.domain.UiEventCard
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
                .background(color = blackOverlay)
                .wrapContentSize(Alignment.Center)
                .padding(vertical = dimensionResource(id = R.dimen.margin_small))
                .verticalScroll(rememberScrollState()),
            content = {
                HomeContent(eventState)
            }
        )
    }
}

@Composable
private fun HomeContent(eventState: List<UiEventCard>) {
    SectionTitle(title = stringResource(id = R.string.home_title_section_to_do_today))
    MediumSpacer()
    HorizontalListOfEvents(list = eventState)
    SectionTitle(title = stringResource(id = R.string.home_title_section_to_this_weekend))
    MediumSpacer()
    HorizontalListOfEvents(list = eventState)
    SectionTitle(title = stringResource(id = R.string.home_title_section_to_do_this_week))
    MediumSpacer()
    HorizontalListOfEvents(list = eventState)
    SectionTitle(title = stringResource(id = R.string.home_title_section_by_theme))
    MediumSpacer()
    HorizontalListOfEvents(list = eventState)
}
