package com.template.feature.home.impl.usecase

import com.squareup.anvil.annotations.ContributesBinding
import com.template.app.di.AppScope
import com.template.core.common.Result
import com.template.feature.home.api.models.HomeData
import com.template.feature.home.api.repository.HomeRepository
import com.template.feature.home.api.usecase.GetHomeDataUseCase
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class GetHomeDataUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository,
) : GetHomeDataUseCase {

    override suspend fun invoke(): Result<HomeData, Throwable> {
        return homeRepository.getHomeData()
    }
}
