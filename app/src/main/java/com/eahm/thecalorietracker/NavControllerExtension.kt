package com.eahm.thecalorietracker

import androidx.navigation.NavController
import com.eahm.core.UiEvent

fun NavController.navigate(uiEvent: UiEvent.Navigate) {
    this.navigate(uiEvent.route)
}