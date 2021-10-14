package com.alif.themovie.data.network.model.configuration

import com.alif.themovie.data.db.ImageConfigEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageConfigNetwork(
    @Json(name = "backdrop_sizes") val backdropSizes: List<String>,
    @Json(name = "base_url") val baseUrl: String,
    @Json(name = "logo_sizes") val logoSizes: List<String>,
    @Json(name = "poster_sizes") val posterSizes: List<String>,
    @Json(name = "profile_sizes") val profileSizes: List<String>,
    @Json(name = "secure_base_url") val secureBaseUrl: String,
    @Json(name = "still_sizes") val stillSizes: List<String>
)

fun ImageConfigNetwork.toImageConfigEntity(): ImageConfigEntity {
    return ImageConfigEntity(secureBaseUrl, backdropSizes, logoSizes, posterSizes, profileSizes)
}

