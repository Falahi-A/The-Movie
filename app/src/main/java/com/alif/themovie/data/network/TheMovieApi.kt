package com.alif.themovie.data.network

import com.alif.themovie.data.network.model.configuration.ConfigurationNetwork
import com.alif.themovie.data.network.model.movie.MoviesNetwork
import com.alif.themovie.data.network.model.movie.now_playing.NowPlayingMoviesNetwork
import com.alif.themovie.data.network.model.people.PeoplePopularNetwork
import com.alif.themovie.data.network.model.tv.TvsNetwork
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieApi {

    // ========== Tv apis ==========

    @GET("discover/tv")
    suspend fun getTvs(): TvsNetwork

    @GET("tv/popular")
    suspend fun getPopularTvs(): TvsNetwork

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTvs(): TvsNetwork

    @GET("trending/tv/{time_window}")
    suspend fun getTrendingTvs(@Path("time_window") timeWindow:String):TvsNetwork

    //    @GET("search/tv")
    //    suspend fun searchTv(@Query("query") query: String)

    // ========== Movie apis ==========

    @GET("discover/movie")
    suspend fun getMovies(): MoviesNetwork

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): NowPlayingMoviesNetwork

    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesNetwork

    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(@Path("time_window") timeWindow:String):MoviesNetwork

//    @GET("search/movie")
//    suspend fun searchMovie(@Query("query") query: String)


    // ========== Config ==========

    @GET("configuration")
    suspend fun getConfiguration(): ConfigurationNetwork

    // ========== People ==========

    @GET("person/popular")
    suspend fun getPopularPeople(): PeoplePopularNetwork




}