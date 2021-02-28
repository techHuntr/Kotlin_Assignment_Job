package com.jobs.assignment.domain.db

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jobs.assignment.R

class DatabaseClient(val context: Context) : RoomDatabase.Callback() {

    private var appDatabase: AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            context.getString(R.string.app_name)
        ).allowMainThreadQueries()
            .addCallback(this)
            .build()

    fun appDatabases(): AppDatabase = appDatabase

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        Log.e("database", "Create")
    }

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
        Log.e("database", "Open")
    }
}
