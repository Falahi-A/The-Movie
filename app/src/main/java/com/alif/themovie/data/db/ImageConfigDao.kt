package com.alif.themovie.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageConfigDao {


    @Query("SELECT * FROM image_config")
    fun getImageConfig(): ImageConfigEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageConfig(imageConfig: ImageConfigEntity):Long


}