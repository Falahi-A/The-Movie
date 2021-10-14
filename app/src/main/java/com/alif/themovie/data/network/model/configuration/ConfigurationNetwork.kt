package com.alif.themovie.data.network.model.configuration

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class
ConfigurationNetwork(
    @Json(name = "change_keys") val changeKeys: List<String>,
    @Json(name = "images") val images: ImageConfigNetwork
)