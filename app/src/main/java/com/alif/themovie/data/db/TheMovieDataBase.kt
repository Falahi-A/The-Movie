package com.alif.themovie.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ImageConfigEntity::class], version = 1)
@TypeConverters(StringListConverter::class)
abstract class TheMovieDataBase : RoomDatabase() {

    abstract fun getImageConfigDao(): ImageConfigDao

}