package com.alif.themovie.ui.custom_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.alif.themovie.databinding.ItemTheMovieRecyclerBinding
import com.alif.themovie.domain.model.discover_movie.Movie
import com.alif.themovie.ui.base.BaseViewHolder
import com.alif.themovie.utils.Constants
import com.alif.themovie.utils.loadImage

class TheMovieAdapter : ListAdapter<Movie, TheMovieAdapter.TheMovieViewHolder>(DifCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheMovieViewHolder {
        return TheMovieViewHolder(
            ItemTheMovieRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TheMovieViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


    inner class TheMovieViewHolder(private val binding: ItemTheMovieRecyclerBinding) :
        BaseViewHolder<Movie>(binding.root) {
        override fun onBind(obj: Movie) {

            binding.txtTitleItemTheMovieRecycler.text = obj.title
            binding.txtDateItemTheMovieRecycler.text = obj.releaseDate
            loadImage(Constants.BASE_IMAGE_URL + obj.backdropPath, binding.imgItemTheMovieRecycler)
        }

    }


    object DifCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }


}