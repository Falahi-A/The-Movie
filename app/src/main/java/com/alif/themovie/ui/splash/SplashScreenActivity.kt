package com.alif.themovie.ui.splash

import android.view.LayoutInflater
import com.alif.themovie.databinding.ActivitySplashScreenBinding
import com.alif.themovie.ui.base.BaseBindingActivity

class SplashScreenActivity : BaseBindingActivity<ActivitySplashScreenBinding>() {




    override val bindingInflater: (LayoutInflater) -> ActivitySplashScreenBinding = { it ->
        ActivitySplashScreenBinding.inflate(it)
    }

    override fun initView() {

    }

}