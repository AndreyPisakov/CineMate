package com.pisakov.data.di

import com.pisakov.data.ApiServiceConstants
import com.pisakov.data.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
internal class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val original = it.request()
            val request = original
                .newBuilder()
                .header("X-API-KEY", BuildConfig.KINOPOISK_API_KEY)
                .method(original.method, original.body)
                .build()
            it.proceed(request)
        }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(ApiServiceConstants.KINOPOISK_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}