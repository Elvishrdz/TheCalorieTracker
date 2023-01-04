package com.eahm.core

import com.eahm.core.util.UiText

sealed class UiEvent {
    object OnSuccess : UiEvent()

    data class ShowSnackbar(
        val uiText: UiText,
    ) : UiEvent()
}
