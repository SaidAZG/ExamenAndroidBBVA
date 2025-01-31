package com.example.examenandroidbbva.di

import com.example.examenandroidbbva.data.local.repository.SessionRepositoryImpl
import com.example.examenandroidbbva.data.remote.repository.ImageRepositoryImpl
import com.example.examenandroidbbva.data.remote.repository.LoginRepositoryImpl
import com.example.examenandroidbbva.domain.repository.ImageRepository
import com.example.examenandroidbbva.domain.repository.LoginRespository
import com.example.examenandroidbbva.domain.repository.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun bindSessionRepository(impl: SessionRepositoryImpl): SessionRepository{
        return impl
    }

    @Singleton
    @Provides
    fun bindLoginRepository(impl: LoginRepositoryImpl): LoginRespository{
        return impl
    }

    @Singleton
    @Provides
    fun bindImageRepository(impl: ImageRepositoryImpl): ImageRepository{
        return impl
    }


}