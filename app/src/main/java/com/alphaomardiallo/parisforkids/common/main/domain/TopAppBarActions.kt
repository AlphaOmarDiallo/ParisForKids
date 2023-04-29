package com.alphaomardiallo.parisforkids.common.main.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alphaomardiallo.parisforkids.R

sealed class TopAppBarActions(
    @DrawableRes var icon: Int,
    @StringRes var description: Int
) {
    object Wifi : TopAppBarActions(
        icon = R.drawable.ic_wifi,
        description = R.string.top_app_bar_icon_wifi_content_description
    )
}
