package com.alif.themovie.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alif.themovie.domain.use_case.GetImageConfigUseCase
import com.alif.themovie.ui.base.BaseViewModel
import com.alif.themovie.utils.Resource
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@ViewModelScoped
class SplashScreenViewModel @Inject constructor(private val getImageConfigUseCase: GetImageConfigUseCase) :
    BaseViewModel() {

    private val _liveData: LiveData<SplashScreenState>
        get() = mutableLiveData
    val mutableLiveData = MutableLiveData<SplashScreenState>()


    fun getImageConfig() {
        getImageConfigUseCase.invoke().onEach { result ->

            when (result) {

                is Resource.Success -> {


                }
                is Resource.Loading -> {

                }
                is Resource.Error -> {

                }

            }

        }.launchIn(viewModelScope)


    }


}