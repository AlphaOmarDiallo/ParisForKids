package com.alphaomardiallo.parisforkids.main.domain

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.alphaomardiallo.parisforkids.R

sealed class NavigationItem(
    var route: String,
    var icon: ImageVector,
    @StringRes var contentDescription: Int,
    @StringRes var title: Int
) {
    object Home : NavigationItem(
        route = R.string.home_screen.toString(),
        icon = Icons.Filled.Home,
        contentDescription = R.string.bottom_navigation_content_description_home,
        title = R.string.bottom_navigation_label_home
    )

    object Events : NavigationItem(
        route = R.string.events_screen.toString(),
        icon = Icons.Filled.Event,
        contentDescription = R.string.bottom_navigation_content_description_event,
        title = R.string.bottom_navigation_label_event
    )

    object Search : NavigationItem(
        route = R.string.search_screen.toString(),
        icon = Icons.Filled.Search,
        contentDescription = R.string.bottom_navigation_content_description_search_activities,
        title = R.string.bottom_navigation_label_search_activities
    )

    object Favorite : NavigationItem(
        route = R.string.favorite_screen.toString(),
        icon = Icons.Filled.Favorite,
        contentDescription = R.string.bottom_navigation_content_description_favorite_activities,
        title = R.string.bottom_navigation_label_favorite_activities
    )

    object Settings : NavigationItem(
        route = R.string.settings_screen.toString(),
        icon = Icons.Filled.Settings,
        contentDescription = R.string.bottom_navigation_content_description_settings_activities,
        title = R.string.bottom_navigation_label_settings_activities
    )
}