package com.alphaomardiallo.parisforkids.main.domain

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.ui.graphics.vector.ImageVector
import com.alphaomardiallo.parisforkids.R

sealed class TopAppBarActions(
    var icon: ImageVector,
    @StringRes var description: Int
) {
    object Wifi : TopAppBarActions(
        icon = Icons.Filled.Wifi,
        description = R.string.top_app_bar_icon_wifi_content_description
    )
}
