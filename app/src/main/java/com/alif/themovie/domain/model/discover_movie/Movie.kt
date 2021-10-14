package com.alif.themovie.domain.model.discover_movie

data class Movie(
    val id: Int,
    val title: String,
    val popularity: Double,
    val genreIds: List<Int>,
    val posterPath: String,
    val backdropPath: String,
    val overView: String,
    val voteAverage: Double,
    val voteCount: Int,
    val releaseDate:String
)