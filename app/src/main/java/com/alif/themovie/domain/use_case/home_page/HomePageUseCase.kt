package com.alif.themovie.domain.use_case.home_page


import com.alif.themovie.data.network.model.movie.now_playing.toMovies
import com.alif.themovie.data.network.model.movie.toMovies
import com.alif.themovie.data.network.model.tv.toTvs
import com.alif.themovie.domain.model.HomePage
import com.alif.themovie.domain.repository.TheMovieRepository
import com.alif.themovie.utils.Resource
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named

/**
 *  fetching popular,nowPlaying,trending movies and pass it to viewModel
 */
class HomePageUseCase @Inject constructor(
    private val repository: TheMovieRepository,
    @Named("IoDispatcher") private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    operator fun invoke(timeWindow: String) = flow<Resource<HomePage>> {
        try {
            emit(Resource.Loading())
            coroutineScope {
                val popularMoviesDeferred = async {
                    repository.getPopularMovies()
                }
                val nowPlayingMoviesDeferred = async {
                    repository.getNowPlayingMovies()
                }
                val trendingMoviesDeferred = async {
                    repository.getTrendingMovies(timeWindow)
                }
                val trendingTvsDeferred = async {
                    repository.getTrendingTvs(timeWindow)
                }


                val popularMovies = popularMoviesDeferred.await()
                val nowPlayingMovies = nowPlayingMoviesDeferred.await()
                val trendingTvs = trendingTvsDeferred.await()
                val trendingMovies = trendingMoviesDeferred.await()

                emit(
                    Resource.Success(
                        HomePage(
                            popularMovies = popularMovies.toMovies(),
                            trendingMovies = trendingMovies.toMovies(),
                            trendingTvs = trendingTvs.toTvs(),
                            nowPlayingMovies = nowPlayingMovies.toMovies()
                        )
                    )
                )
            }


        } catch (ioException: IOException) {
            emit(
                Resource.Error(
                    message = ioException.localizedMessage
                        ?: "couldn't reach server, check your internet please"
                )
            )
        } catch (httpException: HttpException) {
            emit(
                Resource.Error(
                    message = httpException.localizedMessage ?: "an unexpected error occurred"
                )
            )
        }
    }.flowOn(dispatcher)


}