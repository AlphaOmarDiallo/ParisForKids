package com.alphaomardiallo.parisforkids.main.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alphaomardiallo.parisforkids.R

sealed class NavigationItem(
    var route: String,
    @DrawableRes var icon: Int,
    @StringRes var contentDescription: Int,
    @StringRes var title: Int
) {
    object Home : NavigationItem(
        route = R.string.home_screen.toString(),
        icon = R.drawable.ic_home,
        contentDescription = R.string.bottom_navigation_content_description_home,
        title = R.string.bottom_navigation_label_home
    )

    object Events : NavigationItem(
        route = R.string.events_screen.toString(),
        icon = R.drawable.ic_event,
        contentDescription = R.string.bottom_navigation_content_description_event,
        title = R.string.bottom_navigation_label_event
    )

    object Search : NavigationItem(
        route = R.string.search_screen.toString(),
        icon = R.drawable.ic_search,
        contentDescription = R.string.bottom_navigation_content_description_search_activities,
        title = R.string.bottom_navigation_label_search_activities
    )

    object Favorite : NavigationItem(
        route = R.string.favorite_screen.toString(),
        icon = R.drawable.ic_favorite,
        contentDescription = R.string.bottom_navigation_content_description_favorite_activities,
        title = R.string.bottom_navigation_label_favorite_activities
    )

    object Settings : NavigationItem(
        route = R.string.settings_screen.toString(),
        icon = R.drawable.ic_settings,
        contentDescription = R.string.bottom_navigation_content_description_settings_activities,
        title = R.string.bottom_navigation_label_settings_activities
    )
}
