package com.alif.themovie.domain.model

import com.alif.themovie.domain.model.discover_movie.Movie
import com.alif.themovie.domain.model.discover_tv.Tv

/**
 * homePage data
 */
data class HomePage(
    val popularMovies: List<Movie>,
    val trendingMovies: List<Movie>,
    val trendingTvs: List<Tv>,
    val nowPlayingMovies: List<Movie>
)