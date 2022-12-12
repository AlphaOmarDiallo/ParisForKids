package com.alphaomardiallo.parisforkids.main.ui

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.alphaomardiallo.parisforkids.R

@Composable
fun Greeting(name: String, modifier: Modifier) {
    Text(text = "Hello $name!")
}

@Composable
fun TopBar(modifier: Modifier = Modifier, text: String) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(
                onClick = {/*TODO*/ },
                content = {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = stringResource(id = R.string.top_app_bar_icon_content_description)
                    )
                }
            )
        },
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = text)
            }
        },
        actions = {
            TopAppBarActionButton(
                imageVector = Icons.Filled.Wifi,
                description = stringResource(id = R.string.top_app_bar_icon_wifi_content_description)
            ) {
                Log.i(ContentValues.TAG, "TopBar: was clicked")
            }
        }
    )
}

@Composable
fun BottomNav(modifier: Modifier = Modifier) {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = stringResource(id = R.string.bottom_navigation_content_description_list_all_activities)
                )
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_label_list_all_activities))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Event,
                    contentDescription = stringResource(id = R.string.bottom_navigation_content_description_map_activities)
                )
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_label_map_activities))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(id = R.string.bottom_navigation_content_description_search_activities)
                )
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_label_search_activities))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = stringResource(id = R.string.bottom_navigation_content_description_favorite_activities)
                )
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_label_favorite_activities))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
    }
}

@Composable
fun MainContent(modifier: Modifier) {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.backgroundparis),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column() {
            Greeting(name = "Alpha", modifier = modifier)
            Greeting(name = "Clément", modifier = modifier)
            Greeting(name = "Anne", modifier = modifier)
        }
    }
}

