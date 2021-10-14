package com.alif.themovie.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.*
import com.alif.themovie.data.db.TheMovieDataBase
import com.alif.themovie.data.network.TheMovieApi
import com.alif.themovie.data.repository.TheMovieRepositoryImpl
import com.alif.themovie.data.worker.ConfigWorkerFactory
import com.alif.themovie.data.worker.ConfigWorkerFactoryImpl
import com.alif.themovie.data.worker.ConfigWorker
import com.alif.themovie.domain.repository.TheMovieRepository
import com.alif.themovie.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit( baseUrl: String, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): TheMovieApi =
        retrofit.create(TheMovieApi::class.java)

    @Singleton
    @Provides
    fun provideBaseUrl() = Constants.BASE_URL


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor {
            val originalRequest = it.request()
            val newUrlRequest = originalRequest.url().newBuilder()
                .addQueryParameter(Constants.API_KEY, Constants.API_KEY_VALUE)
                .build()

            val requestBuilder = originalRequest.newBuilder()
                .addHeader(Constants.ACCESS_TOKEN_KEY, Constants.ACCESS_TOKEN)
                .url(newUrlRequest)
                .build()
            it.proceed(requestBuilder)
        }

        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideTheMovieRepository(
        theMovieApi: TheMovieApi,
        theMovieDb: TheMovieDataBase
    ): TheMovieRepository =
        TheMovieRepositoryImpl(theMovieApi, theMovieDb)

    @Singleton
    @Provides
    @Named("IoDispatcher")
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    @Named("MainDispatcher")
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main


    @Singleton
    @Provides
    fun provideTheMovieDb(context: Application): TheMovieDataBase {
        return Room.databaseBuilder(
            context,
            TheMovieDataBase::class.java,
            Constants.DATABASE_NAME
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val constraints =
                    Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
                val workRequest =
                    PeriodicWorkRequestBuilder<ConfigWorker>(3, TimeUnit.DAYS).setConstraints(
                        constraints
                    )
                        .build()
                WorkManager.getInstance(context).enqueue(workRequest)

            }
        }).build()
    }


    @IntoMap
    @WorkerKey(ConfigWorker::class)
    @Singleton
    @Provides
    fun provideConfigurationFactory(
        repository: TheMovieRepository,
        @Named("IoDispatcher") dispatcher: CoroutineDispatcher
    ): ConfigWorkerFactory {
        return ConfigWorkerFactoryImpl(repository, dispatcher)
    }


}