package com.template.feature.home.api.usecase

import com.template.core.common.Result
import com.template.feature.home.api.models.HomeData

interface GetHomeDataUseCase {
    suspend operator fun invoke(): Result<HomeData, Throwable>
}
