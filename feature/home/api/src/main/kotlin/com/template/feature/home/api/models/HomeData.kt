package com.template.feature.home.api.models

data class HomeData(
    val title: String,
    val items: List<HomeItem>,
)

data class HomeItem(
    val id: String,
    val name: String,
    val description: String,
)
