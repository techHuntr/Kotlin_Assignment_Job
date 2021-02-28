package com.jobs.assignment.di

import android.content.Context
import androidx.room.Room
import com.jobs.assignment.domain.db.AppDatabase
import com.jobs.assignment.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/* Author: Arafath Misree
*  Root Kick off Class
* */


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }


    @Singleton
    @Provides
    fun buildDatabase(@ApplicationContext app: Context) =
            Room.databaseBuilder(
                    app,
                    AppDatabase::class.java,
                    "Jobs.db").build()


    @Singleton
    @Provides
    fun jobDao(appDatabase: AppDatabase) = appDatabase.getJobDao()
}