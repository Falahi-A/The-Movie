package com.alif.themovie.data.network.model.people

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class People(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "id")
    val id: Int,
    @Json(name = "known_for")
    val knownFor: List<KnownFor>,
    @Json(name = "name")
    val name: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "profile_path")
    val profilePath: String
)