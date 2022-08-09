package com.arslan.nytimesnewsapp

import com.arslan.network.RequestExecutor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
   fun ProvideRepo(requestExecutor: RequestExecutor): NewsRepo{
        return NewsRepo(requestExecutor)
    }
}