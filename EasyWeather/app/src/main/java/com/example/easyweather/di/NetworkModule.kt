package com.example.easyweather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.weatherapi.com"
    private const val API_KEY = "API_KEY"

    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun providesApiKeyInterceptor(): Interceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val modifiedUrl = originalUrl.newBuilder()
            .addQueryParameter("key", API_KEY)
            .build()

        val modifiedRequest = originalRequest.newBuilder()
            .url(modifiedUrl)
            .build()

        chain.proceed(modifiedRequest)
    }

    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        apiKeyInterceptor: Interceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(apiKeyInterceptor)
        .build()

    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
