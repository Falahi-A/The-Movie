package com.alif.themovie.domain.repository

import com.alif.themovie.data.db.ImageConfigEntity
import com.alif.themovie.data.network.model.configuration.ConfigurationNetwork
import com.alif.themovie.data.network.model.movie.MoviesNetwork
import com.alif.themovie.data.network.model.movie.now_playing.NowPlayingMoviesNetwork
import com.alif.themovie.data.network.model.tv.TvsNetwork

interface TheMovieRepository {


    // ========== Movie ==========
    suspend fun getMovies(): MoviesNetwork

    suspend fun getPopularMovies(): MoviesNetwork

    suspend fun getNowPlayingMovies():NowPlayingMoviesNetwork

    suspend fun getTrendingMovies(timeWindow:String): MoviesNetwork


    // ========== Tv ==========

    suspend fun getTvShows(): TvsNetwork

    suspend fun getPopularTvs(): TvsNetwork

    suspend fun getOnTheAirTvs():TvsNetwork

    suspend fun getTrendingTvs(timeWindow:String): TvsNetwork


    // ========== Config ==========

    suspend fun getConfig(): ConfigurationNetwork

    suspend fun insertImageConfigDb(imageConfig: ImageConfigEntity): Long

    suspend fun getImageConfigDb(): ImageConfigEntity

    // ========== Others ==========



}
