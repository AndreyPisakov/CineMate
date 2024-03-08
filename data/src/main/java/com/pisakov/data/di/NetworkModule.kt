package com.pisakov.data.di

import com.pisakov.data.ApiServiceConstants
import com.pisakov.data.BuildConfig
import com.pisakov.data.service.KinopoiskCollectionsApiService
import com.pisakov.data.service.KinopoiskMoviesApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

@Module
internal class NetworkModule {

    @Provides
    @DataScope
    fun provideOkHttpLogInterceptor() = HttpLoggingInterceptor { message ->
        Timber.tag("OkHttp: ")
        Timber.i(message)
    }.setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @DataScope
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
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
    @DataScope
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(ApiServiceConstants.KINOPOISK_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @DataScope
    fun provideKinopoiskMoviesApiService(
        retrofit: Retrofit
    ): KinopoiskMoviesApiService = retrofit.create(KinopoiskMoviesApiService::class.java)

    @Provides
    @DataScope
    fun provideKinopoiskCollectionsApiService(
        retrofit: Retrofit
    ): KinopoiskCollectionsApiService = retrofit.create(KinopoiskCollectionsApiService::class.java)
}