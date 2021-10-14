package com.alif.themovie.data.worker

import android.content.Context
import androidx.work.*
import com.alif.themovie.domain.repository.TheMovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Named

class ConfigWorkerFactoryImpl @Inject constructor(
    private val repository: TheMovieRepository,
    @Named("IoDispatcher") private val dispatcher: CoroutineDispatcher
) :
    ConfigWorkerFactory {
    override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
        return ConfigWorker(appContext, params, repository, dispatcher)
    }
}