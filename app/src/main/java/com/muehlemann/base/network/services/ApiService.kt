package com.muehlemann.base.network.services

import com.muehlemann.base.network.apis.Api
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit

class ApiService(builder: Retrofit.Builder) {

  private val retrofit: Retrofit by lazy {
    builder.baseUrl(Api.API_URL).build()
  }

  private val api: Api by lazy {
    retrofit.create(Api::class.java)
  }

  fun get() = flow {
    val response = api.get()
    if (response.isSuccessful) {
      emit(response.body())
    } else {
      error(response.code())
    }
  }

}