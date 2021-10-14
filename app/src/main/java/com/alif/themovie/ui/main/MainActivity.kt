package com.alif.themovie.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alif.themovie.R
import com.alif.themovie.databinding.ActivityMainBinding
import com.alif.themovie.ui.base.BaseBindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun initView() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragment.id) as NavHostFragment
        binding.bottomNavigation.setupWithNavController(navHostFragment.navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.myListFragment,
                R.id.myAccountFragment,
                R.id.categoryFragment
            )
        )

        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)

    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = { layoutInflater ->
        ActivityMainBinding.inflate(layoutInflater)
    }



}