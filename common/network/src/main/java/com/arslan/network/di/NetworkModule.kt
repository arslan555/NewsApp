package com.arslan.network.di

import com.arslan.network.BuildConfig
import com.arslan.network.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }

    @Provides
    @Singleton
    fun providesAuthInterceptor(): Interceptor {
        return Interceptor {
            val newRequest = it.request()
                .newBuilder()
                .url(it.request().url().newBuilder().addQueryParameter("api_key", "API_KEY").build()).build()
            it.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    fun providesRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun  providesApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}