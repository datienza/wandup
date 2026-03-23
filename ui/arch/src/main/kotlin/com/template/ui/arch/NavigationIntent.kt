package com.template.ui.arch

import androidx.compose.runtime.Immutable

interface NavigationIntent

@Immutable
interface Navigator<N : NavigationIntent> {
    suspend fun navigate(navigationIntent: N)
}
