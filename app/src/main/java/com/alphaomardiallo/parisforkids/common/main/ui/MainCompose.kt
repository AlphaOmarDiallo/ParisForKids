package com.alphaomardiallo.parisforkids.common.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.events.ui.EventsScreen
import com.alphaomardiallo.parisforkids.favorite.ui.FavoriteScreen
import com.alphaomardiallo.parisforkids.home.ui.HomeScreen
import com.alphaomardiallo.parisforkids.common.main.domain.NavigationItem
import com.alphaomardiallo.parisforkids.common.main.domain.TopAppBarActions
import com.alphaomardiallo.parisforkids.search.ui.SearchScreen
import com.alphaomardiallo.parisforkids.settings.ui.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier, text: String) {
    val actions = listOf(TopAppBarActions.Wifi)
    TopAppBar(
        modifier = modifier,
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = text)
            }
        },
        actions = {
            actions.forEach { action ->
                TopAppBarActionButton(
                    imageVector = ImageVector.vectorResource(id = action.icon),
                    description = stringResource(id = action.description)
                ) {
                    /*TODO*/
                }
            }
        }
    )
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier, navController: NavController) {
    val navigationItems = listOf(
        NavigationItem.Home,
        NavigationItem.Events,
        NavigationItem.Search,
        NavigationItem.Favorite,
        NavigationItem.Settings
    )
    BottomAppBar(
        modifier = modifier,
        containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navigationItems.forEach { navItem ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = navItem.icon),
                        contentDescription = stringResource(id = navItem.contentDescription)
                    )
                },
                label = { Text(stringResource(id = navItem.title)) },
                alwaysShowLabel = true,
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun MainContent() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.backgroundparis),
            contentDescription = stringResource(id = R.string.background_image_content_description),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(route = NavigationItem.Home.route) {
            HomeScreen()
        }

        composable(route = NavigationItem.Events.route) {
            EventsScreen()
        }

        composable(route = NavigationItem.Search.route) {
            SearchScreen()
        }

        composable(route = NavigationItem.Favorite.route) {
            FavoriteScreen()
        }

        composable(route = NavigationItem.Settings.route) {
            SettingsScreen()
        }
    }
}
