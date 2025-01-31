package com.example.examenandroidbbva.di

import com.example.examenandroidbbva.data.local.repository.SessionRepositoryImpl
import com.example.examenandroidbbva.domain.repository.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSessionRepository(impl: SessionRepositoryImpl): SessionRepository

}