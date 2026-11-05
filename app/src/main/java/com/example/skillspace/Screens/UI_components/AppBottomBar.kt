package com.example.practice.SkillSpace

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomBar(navController: NavHostController) {

    val DeepOrange = Color(0xFFCC5500)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.DarkGray,
        modifier = Modifier.height(119.dp)
    ) {

        val itemColors = NavigationBarItemDefaults.colors(
            selectedIconColor = DeepOrange,   // Color when selected
            unselectedIconColor = Color.LightGray,  // Color when not selected
            selectedTextColor = DeepOrange,
            unselectedTextColor = Color.LightGray,
            indicatorColor = Color.Transparent // Optional: removes the pill background
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home",
                )
            },
            selected = currentDestination?.hasRoute<NavRoutes.HomeScreen>() == true,
            onClick = {
                navController.navigate(NavRoutes.HomeScreen) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            colors = itemColors,
            label = { Text(text = "Home", fontSize = 12.sp) },
            alwaysShowLabel = true,
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Roadmap",
                )
            },
            selected = currentDestination?.hasRoute<NavRoutes.Schedule>() == true,
            onClick = {
                navController.navigate(NavRoutes.Schedule) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            colors = itemColors,
            label = { Text(text = "Schedule", fontSize = 12.sp) },
            alwaysShowLabel = true,
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "resources",
                )
            },
            selected = currentDestination?.hasRoute<NavRoutes.Resources>() == true,
            onClick = {
                navController.navigate(NavRoutes.Resources) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            colors = itemColors,
            label = { Text(text = "Resources", fontSize = 12.sp) },
            alwaysShowLabel = true,
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Popular custom playlist",
                )
            },
            selected = currentDestination?.hasRoute<NavRoutes.TrendList>() == true,
            onClick = {
                navController.navigate(NavRoutes.TrendList) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            colors = itemColors,
            label = { Text(text = "Trends", fontSize = 12.sp) },
            alwaysShowLabel = true,
        )
    }
}
