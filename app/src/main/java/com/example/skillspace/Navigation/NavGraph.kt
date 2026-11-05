package com.example.practice.SkillSpace

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.skillspace.Screens.PreviewScreen.PlayPreview

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    Scaffold(
        topBar = { AppTopBar() },
        bottomBar = { AppBottomBar(navController = navController) },
        floatingActionButton = { FAB() }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = NavRoutes.HomeScreen,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<NavRoutes.HomeScreen> {
                HomeScreen(navController)
            }

            composable<NavRoutes.Resources> {
                Resources(navController)
            }

            composable<NavRoutes.Schedule> {
                Schedule(navController)
            }

            composable<NavRoutes.TrendList> {
                TrendList(navController)
            }

            composable<NavRoutes.PlayPreview> {
                PlayPreview(navController)
            }
        }

    }
}
