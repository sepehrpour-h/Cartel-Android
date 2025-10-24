package com.sepehrpour.cartel.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sepehrpour.cartel.data.model.Destinations
import com.sepehrpour.cartel.presentation.home.HomeScreen
import com.sepehrpour.cartel.presentation.scenario.ScenarioScreen
import com.sepehrpour.cartel.presentation.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Splash,
        modifier = modifier
    ) {
        composable(Destinations.Splash) {
            SplashScreen(onSplashFinished = {
                navController.navigate(Destinations.Home) {
                    popUpTo(Destinations.Splash) { inclusive = true }
                }
            })
        }
        composable(Destinations.Home) {
            HomeScreen(
                onScenarioClick = { scenarioId ->
                    navController.navigate("${Destinations.Scenario}/$scenarioId")
                }
            )
        }
        composable("${Destinations.Scenario}/{scenarioId}") { backStackEntry ->
            val scenarioId = backStackEntry.arguments?.getString("scenarioId") ?: return@composable
            ScenarioScreen(
                scenarioId = scenarioId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}