package com.template.feature.home.ui

import com.template.ui.arch.NavigationIntent

sealed interface HomeNavigationIntent : NavigationIntent {
    data class NavigateToDetail(val itemId: String) : HomeNavigationIntent
}
