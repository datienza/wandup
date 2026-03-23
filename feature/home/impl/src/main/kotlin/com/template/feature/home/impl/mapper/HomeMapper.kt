package com.template.feature.home.impl.mapper

import com.template.backend.home.dto.HomeItemDto
import com.template.backend.home.dto.HomeResponseDto
import com.template.feature.home.api.models.HomeData
import com.template.feature.home.api.models.HomeItem

fun HomeResponseDto.toDomain(): HomeData = HomeData(
    title = title,
    items = items.map { it.toDomain() },
)

fun HomeItemDto.toDomain(): HomeItem = HomeItem(
    id = id,
    name = name,
    description = description,
)
