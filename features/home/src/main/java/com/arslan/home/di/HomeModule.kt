package com.arslan.home.di

import com.arslan.home.data.HomeRepository
import com.arslan.home.data.HomeRepositoryImpl
import com.arslan.home.datasource.remote.HomeRemoteDataSource
import com.arslan.utils.CoroutineDispatchers
import com.arslan.utils.Dispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Singleton
    @Provides
    fun provideHomeRepository(
        @Dispatcher(CoroutineDispatchers.IO)
        ioDispatcher: CoroutineDispatcher,
        homeRemoteDataSource: HomeRemoteDataSource
    ): HomeRepository {
        return HomeRepositoryImpl(ioDispatcher, homeRemoteDataSource)
    }

}