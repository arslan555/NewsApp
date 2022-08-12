package com.arslan.network.di

import com.arslan.network.BuildConfig
import com.arslan.network.Constants
import com.arslan.network.RequestExecutor
import com.arslan.network.retrofit.ApiInterface
import com.arslan.network.retrofit.RetrofitRequestExecutor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesAuthInterceptor(): Interceptor {
        return Interceptor {
            val newRequest = it.request()
                .newBuilder()
                .url(it.request().url().newBuilder().addQueryParameter(Constants.QueryParams.API_KEY, BuildConfig.apiKey).build()).build()
            it.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    fun providesRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun  providesApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkExecutor(apiInterface: ApiInterface): RequestExecutor {
        return RetrofitRequestExecutor(apiInterface)
    }


}