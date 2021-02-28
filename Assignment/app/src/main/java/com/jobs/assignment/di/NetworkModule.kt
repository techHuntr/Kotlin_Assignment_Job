package com.jobs.assignment.di

import com.google.gson.GsonBuilder
import com.jobs.assignment.network.RetrofitService
import com.jobs.assignment.network.SupportInterceptor
import com.jobs.assignment.network.model.JobDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/* Author: Arafath Misree
*  Class to build reftorfit client with it's dependencies
* */

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper(): JobDtoMapper {
        return JobDtoMapper()
    }

    private fun httpClient(
        debug: Boolean,
        supportInterceptor: SupportInterceptor
    ): OkHttpClient {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        val clientBuilder = OkHttpClient.Builder()

        if (debug) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        clientBuilder.addInterceptor(supportInterceptor)

        return clientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://us-central1-jobs-75769.cloudfunctions.net/app/")
            .client(httpClient(debug = true, supportInterceptor = SupportInterceptor()))
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RetrofitService::class.java)
    }
}