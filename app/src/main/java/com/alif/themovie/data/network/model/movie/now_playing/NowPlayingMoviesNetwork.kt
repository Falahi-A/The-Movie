package com.alif.themovie.data.network.model.movie.now_playing

import com.alif.themovie.data.network.model.movie.MovieNetwork
import com.alif.themovie.domain.model.discover_movie.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NowPlayingMoviesNetwork(
    @Json(name = "dates") val dates: Dates,
    @Json(name = "page") val page: Int,
    @Json(name = "results") val nowPlayingMovies: List<MovieNetwork>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)

fun NowPlayingMoviesNetwork.toMovies(): List<Movie> {
    return nowPlayingMovies.map {
        Movie(it.id, it.title?:"", it.popularity, it.genreIds,posterPath = it.posterPath,backdropPath = it.backdropPath,overView = it.overview,voteAverage = it.vote_average,voteCount = it.vote_count,releaseDate = it.releaseDate)
    }
}