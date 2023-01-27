package com.codingwithmitch.kmm_learning_mitch.datasource.network.model

import kotlinx.serialization.SerialName


data class RecipeSearchResponse(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: Any,
    @SerialName("results")
    val results: List<RecipeDto>
)