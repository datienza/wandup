package com.template.backend.home.datasource

import com.template.backend.core.BaseNetworkDataSource
import com.template.backend.home.api.HomeApi
import com.template.backend.home.dto.HomeResponseDto
import javax.inject.Inject

class HomeNetworkDataSource @Inject constructor(
    private val homeApi: HomeApi,
) : BaseNetworkDataSource() {

    suspend fun getHome(): Result<HomeResponseDto> = safeApiCall {
        homeApi.getHome()
    }
}
