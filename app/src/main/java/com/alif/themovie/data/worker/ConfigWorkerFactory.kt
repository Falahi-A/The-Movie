package com.alif.themovie.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

interface ConfigWorkerFactory {

    fun create(appContext: Context, params: WorkerParameters): ListenableWorker

}