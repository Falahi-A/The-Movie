package com.alif.themovie.data.network.model.movie.now_playing

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Dates(
    @Json(name = "maximum") val maximum: String,
    @Json(name = "minimum") val minimum: String
)