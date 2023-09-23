package com.muehlemann.base.hilt

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.muehlemann.base.network.services.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

  @Provides
  fun providesOkHttp(): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
      })
      .build()
  }

  @Provides
  fun providesGson(): Gson {
    return GsonBuilder()
      .serializeNulls()
      .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
      .setPrettyPrinting()
      .setVersion(1.0)
      .create()
  }

  @Provides
  fun providesRetrofitBuilder(okHttpClient: OkHttpClient, gson: Gson): Retrofit.Builder {
    return Retrofit.Builder()
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create(gson))

  }

  @Provides
  fun providesWeatherService(builder: Retrofit.Builder): ApiService {
    return ApiService(builder)
  }
}