package com.template.feature.home.api.repository

import com.template.core.common.Result
import com.template.feature.home.api.models.HomeData

interface HomeRepository {
    suspend fun getHomeData(): Result<HomeData, Throwable>
}
