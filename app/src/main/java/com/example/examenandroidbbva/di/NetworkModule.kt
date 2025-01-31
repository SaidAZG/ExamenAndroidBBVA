package com.example.examenandroidbbva.di

import com.example.examenandroidbbva.data.api.ApiLoginService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGson (): Gson = GsonBuilder().setLenient().create()!!

    @Qualifier
    annotation class ApiLogin

    private const val BASE_URL_LOGIN = "https://private-6eaf4c-examenbbva.apiary-mock.com/"

    @Singleton
    @Provides
    @ApiLogin
    fun provideRetrofitLogin(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_LOGIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(OkHttpClient.Builder().build())
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginApiService(@ApiLogin retrofit: Retrofit): ApiLoginService {
        return retrofit.create(ApiLoginService::class.java)
    }
}