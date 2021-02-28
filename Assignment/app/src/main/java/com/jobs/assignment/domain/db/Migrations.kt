package com.jobs.assignment.domain.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//Use this method to migrate existing room db before send the update to play store

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        //example for drop column from user table
        database.execSQL("CREATE TABLE test (name TEXT,  PRIMARY KEY(uid))")
        database.execSQL("INSERT INTO test (name) SELECT name FROM User")
        database.execSQL("DROP TABLE User")
        database.execSQL("ALTER TABLE test RENAME TO User")
    }
}
