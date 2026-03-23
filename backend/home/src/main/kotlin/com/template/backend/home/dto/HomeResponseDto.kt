package com.template.backend.home.dto

import kotlinx.serialization.Serializable

@Serializable
data class HomeResponseDto(
    val title: String,
    val items: List<HomeItemDto>,
)

@Serializable
data class HomeItemDto(
    val id: String,
    val name: String,
    val description: String,
)
