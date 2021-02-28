package com.jobs.assignment.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jobs.assignment.domain.db.converters.ObjectConverter
import com.jobs.assignment.domain.db.entities.JobDao
import com.jobs.assignment.domain.model.Job

@Database(
    entities = [Job::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ObjectConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getJobDao(): JobDao
}