package com.alif.themovie.domain.model.discover_tv

data class Tv(
    val id: Int,
    val name: String,
    val popularity: Double,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val firstAirDate: String
)