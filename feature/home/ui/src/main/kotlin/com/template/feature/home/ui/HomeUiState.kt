package com.template.feature.home.ui

import androidx.compose.runtime.Immutable
import com.template.feature.home.api.models.HomeItem
import com.template.ui.arch.UiState

@Immutable
data class HomeUiState(
    val isLoading: Boolean = true,
    val title: String = "",
    val items: List<HomeItem> = emptyList(),
    val error: String? = null,
) : UiState
