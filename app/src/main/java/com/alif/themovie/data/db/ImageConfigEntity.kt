package com.alif.themovie.data.db

import androidx.room.*
import com.alif.themovie.domain.model.ImageConfig

@Entity(tableName = "image_config")
data class ImageConfigEntity(
    @ColumnInfo(name = "secure_base_url") val baseUrl: String,
    @ColumnInfo(name = "backdrop_sizes") val backdropSizes: List<String>,
    @ColumnInfo(name = "logo_sizes") val logoSizes: List<String>,
    @ColumnInfo(name = "poster_sizes") val posterSizes: List<String>,
    @ColumnInfo(name = "profile_sizes") val profileSizes: List<String>
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int = 1
}

fun ImageConfigEntity.toImageConfig() = ImageConfig(
    baseUrl = baseUrl,
    backdropSizes = backdropSizes,
    logoSizes = logoSizes,
    posterSizes = posterSizes
)