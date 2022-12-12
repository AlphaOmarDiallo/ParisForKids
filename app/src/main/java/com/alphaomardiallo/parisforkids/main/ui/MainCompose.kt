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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.main.domain.NavigationItem

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
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Events,
        NavigationItem.Search,
        NavigationItem.Favorite,
        NavigationItem.Settings
    )
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = item.contentDescription)
                    )
                },
                label = { Text(stringResource(id = item.title)) },
                selectedContentColor = Color.Cyan,
                unselectedContentColor = Color.White,
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    /* Add code later */
                }
            )
        }
    }
}

@Composable
fun MainContent(modifier: Modifier) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.backgroundparis),
            contentDescription = stringResource(id = R.string.background_image_content_description),
            contentScale = ContentScale.FillBounds
        )

        Column {
            Greeting(name = "Alpha", modifier = modifier)
            Greeting(name = "Clément", modifier = modifier)
            Greeting(name = "Anne", modifier = modifier)
        }
    }
}

