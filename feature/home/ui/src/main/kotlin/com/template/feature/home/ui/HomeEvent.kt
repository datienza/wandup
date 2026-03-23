package com.template.feature.home.ui

import com.template.ui.arch.UiEvent

sealed interface HomeEvent : UiEvent {
    data object Refresh : HomeEvent
    data class ItemClicked(val itemId: String) : HomeEvent
}
