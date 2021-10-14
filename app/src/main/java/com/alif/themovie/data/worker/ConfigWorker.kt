package com.alif.themovie.data.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.alif.themovie.data.network.model.configuration.toImageConfigEntity
import com.alif.themovie.domain.repository.TheMovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Named

/**
 * fetch configuration and save it to data base worker
 */

class ConfigWorker(
    appContext: Context,
    workerParams: WorkerParameters,
    private val repository: TheMovieRepository,
    @Named("IoDispatcher") private val dispatcher: CoroutineDispatcher
) : CoroutineWorker(appContext, workerParams) {


    override suspend fun doWork(): Result = withContext(dispatcher) {
        try {
            Log.d(TAG, " DoWork method is called")
            val result = repository.getConfig()
            val insertImageConfigDb =
                repository.insertImageConfigDb(result.images.toImageConfigEntity())
            Log.d(TAG, insertImageConfigDb.toString())
            Result.success()
        } catch (e: Exception) {
            e.localizedMessage?.let {
                Log.d(TAG, it)
            }
            Result.retry()
        }


    }


    companion object {

        private const val TAG = "ConfigWorker:"
    }

}


