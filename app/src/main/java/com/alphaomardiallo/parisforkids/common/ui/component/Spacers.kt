package com.alphaomardiallo.parisforkids.common.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.alphaomardiallo.parisforkids.R

@Composable
fun SmallSpacer(modifier: Modifier = Modifier) {
    Spacer(modifier.size(dimensionResource(id = R.dimen.margin_small)))
}

@Composable
fun MediumSpacer(modifier: Modifier = Modifier) {
    Spacer(modifier.size(dimensionResource(id = R.dimen.margin_medium)))
}

@Composable
fun LargeSpacer(modifier: Modifier = Modifier) {
    Spacer(modifier.size(dimensionResource(id = R.dimen.margin_large)))
}
