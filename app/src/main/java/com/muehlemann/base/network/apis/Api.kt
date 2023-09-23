package com.muehlemann.base.network.apis

import com.muehlemann.base.models.Model
import retrofit2.Response
import retrofit2.http.GET

interface Api {

  companion object {
    const val API_URL = "http://api.endpoint.com"
  }

  @GET("route")
  suspend fun get(): Response<Model>

}