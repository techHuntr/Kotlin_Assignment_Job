package com.jobs.assignment.domain.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ObjectConverter {
    @TypeConverter
    fun fromStringList(value: String?): List<String> {
        val listType: Type = object : TypeToken<List<String>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromObjectList(obj: List<String>): String {
        val gson = Gson()
        return gson.toJson(obj)
    }

}