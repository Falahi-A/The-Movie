package com.alif.themovie.data.repository


import com.alif.themovie.data.db.ImageConfigEntity
import com.alif.themovie.data.db.TheMovieDataBase
import com.alif.themovie.data.network.TheMovieApi
import com.alif.themovie.data.network.model.configuration.ConfigurationNetwork
import com.alif.themovie.data.network.model.movie.MoviesNetwork
import com.alif.themovie.data.network.model.movie.now_playing.NowPlayingMoviesNetwork
import com.alif.themovie.data.network.model.tv.TvsNetwork
import com.alif.themovie.domain.repository.TheMovieRepository
import javax.inject.Inject

/**
 *  Centralised data repository
 */
class TheMovieRepositoryImpl @Inject constructor(
    private val theMovieApi: TheMovieApi,
    private val theMovieDb: TheMovieDataBase
) : TheMovieRepository {
    private val imageConfigDao = theMovieDb.getImageConfigDao()


    override suspend fun getMovies(): MoviesNetwork {
        return theMovieApi.getMovies()
    }

    override suspend fun getPopularMovies(): MoviesNetwork {
        return theMovieApi.getPopularMovies()
    }

    override suspend fun getNowPlayingMovies(): NowPlayingMoviesNetwork {
        return theMovieApi.getNowPlayingMovies()
    }

    override suspend fun getTrendingMovies(timeWindow: String): MoviesNetwork {
        return theMovieApi.getTrendingMovies(timeWindow)
    }


    override suspend fun getTvShows(): TvsNetwork {
        return theMovieApi.getTvs()
    }

    override suspend fun getPopularTvs(): TvsNetwork {
        return theMovieApi.getPopularTvs()
    }

    override suspend fun getOnTheAirTvs(): TvsNetwork {
        return theMovieApi.getOnTheAirTvs()
    }

    override suspend fun getTrendingTvs(timeWindow: String): TvsNetwork {
        return theMovieApi.getTrendingTvs(timeWindow)
    }

    override suspend fun getConfig(): ConfigurationNetwork {
        return theMovieApi.getConfiguration()
    }

    override suspend fun insertImageConfigDb(imageConfig: ImageConfigEntity): Long {
        return imageConfigDao.insertImageConfig(imageConfig)
    }


    override suspend fun getImageConfigDb(): ImageConfigEntity {
        return imageConfigDao.getImageConfig()
    }


}