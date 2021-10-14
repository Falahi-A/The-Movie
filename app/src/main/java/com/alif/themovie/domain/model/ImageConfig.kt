package com.alif.themovie.domain.model

data class ImageConfig(
    private val baseUrl: String,
    private val backdropSizes: List<String>,
    private val logoSizes: List<String>,
    private val posterSizes:List<String>
)

