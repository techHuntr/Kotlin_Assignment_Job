package com.jobs.assignment.di

import com.jobs.assignment.domain.db.entities.JobDao
import com.jobs.assignment.network.RetrofitService
import com.jobs.assignment.network.model.JobDtoMapper
import com.jobs.assignment.repository.JobRepository
import com.jobs.assignment.repository.JobRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


/* Author: Arafath Misree
*  Repository module class
* */

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepository(
            retrofitService: RetrofitService,
            jobDao: JobDao,
            jobDtoMapper: JobDtoMapper
    ): JobRepository {
        return JobRepositoryImpl(retrofitService, jobDao, jobDtoMapper)
    }
}