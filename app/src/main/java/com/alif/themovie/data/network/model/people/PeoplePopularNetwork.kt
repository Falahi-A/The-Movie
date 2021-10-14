package com.alif.themovie.data.network.model.people

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PeoplePopularNetwork(
    @Json(name = "page")
    val page: Int,
    @Json(name = "people")
    val people: List<People>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)