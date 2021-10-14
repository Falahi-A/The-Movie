package com.alif.themovie.domain.use_case

import com.alif.themovie.data.db.toImageConfig
import com.alif.themovie.domain.model.ImageConfig
import com.alif.themovie.domain.repository.TheMovieRepository
import com.alif.themovie.utils.Resource
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

/**
 * fetching image's configuration from db
 */
class GetImageConfigUseCase @Inject constructor(private val repository: TheMovieRepository) {

    operator fun invoke() = flow<Resource<ImageConfig>> {
        try {
            emit(Resource.Loading())
            val imageConfigDb = repository.getImageConfigDb()
            emit(Resource.Success(imageConfigDb.toImageConfig()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage))
        }
    }

}