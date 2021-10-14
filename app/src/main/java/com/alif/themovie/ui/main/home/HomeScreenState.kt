package com.alif.themovie.ui.main.home

import com.alif.themovie.domain.model.discover_movie.Movie
import com.alif.themovie.domain.model.discover_tv.Tv

data class HomeScreenState(
    var isLoading: Boolean = false,
    var popularMovies: List<Movie> =emptyList(),
    var trendingMovies: List<Movie> =emptyList(),
    var trendingTvs: List<Tv> =emptyList(),
    var nowPlayingMovies: List<Movie> =emptyList(),
    var error: String = ""
)