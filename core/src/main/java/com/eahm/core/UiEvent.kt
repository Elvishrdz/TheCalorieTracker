package com.eahm.core

sealed class UiEvent {
    class Navigate(val route: String) : UiEvent()
}
