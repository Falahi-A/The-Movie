package com.alif.themovie.utils

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.alif.themovie.R


fun loadImage(url: String, imageView: AppCompatImageView) {
        Glide.with(imageView.context).load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageView)

}