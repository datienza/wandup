package com.template.backend.home.api

import com.template.backend.home.dto.HomeResponseDto
import retrofit2.http.GET

interface HomeApi {
    @GET("home")
    suspend fun getHome(): HomeResponseDto
}
