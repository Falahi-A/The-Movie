package com.alif.themovie.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alif.themovie.R
import com.alif.themovie.databinding.FragmentHomeBinding
import com.alif.themovie.domain.model.discover_movie.Movie
import com.alif.themovie.ui.base.BaseBindingFragment
import com.alif.themovie.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseBindingFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()


    private fun initTrendingMoviesRecycler(list: List<Movie>) {

        binding.recyclerTrendingMovies.apply {
            context?.let {
                setTitle(getString(R.string.trending))
                setButtonTogglesText(getString(R.string.today), getString(R.string.this_week))
            }
            setData(list)

        }
    }


    private fun initTrailersRecycler(list: List<Movie>) {

        binding.recyclerTrailers.apply {
            context?.let {
                setTitle(getString(R.string.latest_trailers))
                setButtonTogglesText(getString(R.string.on_tv), getString(R.string.on_movie))
            }
            setData(list)

        }
    }

    private fun initPopularRecycler(list: List<Movie>) {
        binding.recyclerPopular.apply {
            context?.let {
                setTitle(getString(R.string.what_is_popular))
                setButtonTogglesText(getString(R.string.on_tv), getString(R.string.on_movie))
            }
            setData(list)

        }
    }


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        { layoutInflater, viewGroup, isAttached ->
            FragmentHomeBinding.inflate(layoutInflater, viewGroup, isAttached)
        }

    override fun initView() {

        viewModel.moviesList.observe(viewLifecycleOwner, { state ->

            when {
                state.isLoading -> {
                    displayRecyclers(false)
                    (activity as MainActivity).displayCustomErrorView(false)
                    (activity as MainActivity).displayProgress(true)
                }
                state.error != "" -> {
                    displayRecyclers(false)
                    (activity as MainActivity).displayProgress(false)
                    (activity as MainActivity).displayCustomErrorView(true)
                    (activity as MainActivity).getCustomErrorView().setError(state.error)

                }
                else -> {
                    (activity as MainActivity).displayCustomErrorView(false)
                    (activity as MainActivity).displayProgress(false)
                    displayRecyclers(true)
                    initPopularRecycler(state.popularMovies)
                    initTrailersRecycler(state.nowPlayingMovies)
                    initTrendingMoviesRecycler(state.trendingMovies)
                }
            }


        })

        (activity as MainActivity).getCustomErrorView().setReloadListener {
            viewModel.getHomeData()
        }
    }

    private fun displayRecyclers(isDisplayed: Boolean) {
        if (isDisplayed) binding.recyclersHomeLayout.visibility = View.VISIBLE else View.INVISIBLE
    }
}