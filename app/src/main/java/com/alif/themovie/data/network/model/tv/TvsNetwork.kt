package com.alif.themovie.data.network.model.tv

import com.alif.themovie.domain.model.discover_tv.Tv
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TvsNetwork(
    @Json(name = "results")
    val tvs: List<TvNetwork>,
    @Json(name = "page")
    val page: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

fun TvsNetwork.toTvs(): List<Tv> {
    return tvs.map {
        Tv(
            id = it.id,
            name = it.name,
            popularity = it.popularity,
            overview = it.overview,
            posterPath = it.posterPath ?: "",
            backdropPath = it.backdropPath ?: "",
            voteCount = it.voteCount,
            firstAirDate = it.firstAirDate,
            voteAverage = it.voteAverage
        )
    }
}