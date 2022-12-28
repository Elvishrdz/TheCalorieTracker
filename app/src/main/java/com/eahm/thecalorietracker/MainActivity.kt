package com.eahm.thecalorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eahm.core.Route
import com.eahm.core.UiEvent
import com.eahm.onboarding_presentation.welcome.WelcomeScreen
import com.eahm.thecalorietracker.ui.theme.TheCalorieTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheCalorieTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME,
                ) {
                    composable(Route.WELCOME) {
                        WelcomeScreen(
                            onContinue = {
                                navController.navigate(
                                    UiEvent.Navigate(Route.AGE)
                                )
                            },
                        )
                    }
                    composable(Route.AGE) {

                    }
                    composable(Route.GENDER) {

                    }
                    composable(Route.HEIGHT) {

                    }
                    composable(Route.WEIGHT) {

                    }
                    composable(Route.NUTRIENT_GOAL) {

                    }
                    composable(Route.ACTIVITY) {

                    }
                    composable(Route.GOAL) {

                    }
                    composable(Route.TRACKER_OVERVIEW) {

                    }
                    composable(Route.SEARCH) {

                    }
                }
            }
        }
    }
}
