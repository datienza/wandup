package com.template.feature.home.impl.repository

import com.squareup.anvil.annotations.ContributesBinding
import com.template.app.di.AppScope
import com.template.backend.home.datasource.HomeNetworkDataSource
import com.template.core.common.Result
import com.template.feature.home.api.models.HomeData
import com.template.feature.home.api.repository.HomeRepository
import com.template.feature.home.impl.mapper.toDomain
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ContributesBinding(AppScope::class)
class HomeRepositoryImpl @Inject constructor(
    private val homeNetworkDataSource: HomeNetworkDataSource,
) : HomeRepository {

    override suspend fun getHomeData(): Result<HomeData, Throwable> {
        return homeNetworkDataSource.getHome().fold(
            onSuccess = { Result.Success(it.toDomain()) },
            onFailure = { Result.Failure(it) },
        )
    }
}
