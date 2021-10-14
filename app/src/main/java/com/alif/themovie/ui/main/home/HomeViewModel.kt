package com.alif.themovie.ui.main.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alif.themovie.domain.use_case.home_page.HomePageUseCase
import com.alif.themovie.ui.base.BaseViewModel
import com.alif.themovie.utils.Constants
import com.alif.themovie.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homePageUseCase: HomePageUseCase) :
    BaseViewModel() {
    private val _moviesList = MutableLiveData<HomeScreenState>()
    val moviesList: LiveData<HomeScreenState> = _moviesList
    private val homeState = HomeScreenState()

    init {
        getHomeData()
    }

     fun getHomeData() {
        homePageUseCase(Constants.DAY).onEach { result ->

            when (result) {
                is Resource.Success -> {
                    _moviesList.postValue(
                        homeState.apply {
                            isLoading = false
                            result.data?.let {
                                popularMovies = result.data.popularMovies
                                trendingMovies = result.data.trendingMovies
                                nowPlayingMovies = result.data.nowPlayingMovies
                            }

                            error = ""
                        }
                    )
                }
                is Resource.Loading -> {
                    _moviesList.postValue(homeState.apply {
                        isLoading = true
                        result.data?.let {
                            popularMovies = emptyList()
                            trendingMovies = emptyList()
                            nowPlayingMovies = emptyList()
                        }
                        error = ""
                    })
                }
                is Resource.Error -> {
                    _moviesList.postValue(
                        homeState.apply {
                            isLoading = false
                            result.data?.let {
                                popularMovies = emptyList()
                                trendingMovies = emptyList()
                                nowPlayingMovies = emptyList()
                            }
                            error = result.message ?: "an unexpected error occurred"
                        }

                    )

                }
            }
        }.launchIn(viewModelScope)

    }


}