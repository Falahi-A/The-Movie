package com.alif.themovie.data.network.model.movie

import com.alif.themovie.domain.model.discover_movie.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesNetwork(
    @Json(name = "results")
    val movies: List<MovieNetwork>,
    @Json(name = "page")
    val page: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

fun MoviesNetwork.toMovies(): List<Movie> {
    return  movies.map {
        Movie(id = it.id, title = it.title, popularity = it.popularity, genreIds = it.genreIds,posterPath = it.posterPath,backdropPath = it.backdropPath,overView = it.overview,voteAverage = it.vote_average,voteCount = it.vote_count,releaseDate = it.releaseDate)
    }
}