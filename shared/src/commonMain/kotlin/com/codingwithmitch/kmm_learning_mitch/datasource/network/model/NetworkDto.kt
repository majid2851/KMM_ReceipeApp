package com.codingwithmitch.kmm_learning_mitch.datasource.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class NetworkDto(
//    @SerialName("cooking_instructions")
//    val cookingInstructions: Any,
    @SerialName("date_added")
    val dateAdded: String,
    @SerialName("date_updated")
    val dateUpdated: String,
    @SerialName("description")
    val description: String,
    @SerialName("featured_image")
    val featuredImage: String,
    @SerialName("ingredients")
    val ingredients: List<String>,
    @SerialName("long_date_added")
    val longDateAdded: Long,
    @SerialName("long_date_updated")
    val longDateUpdated: Long,
    @SerialName("pk")
    val pk: Int,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("rating")
    val rating: Int,
    @SerialName("source_url")
    val sourceUrl: String,
    @SerialName("title")
    val title: String
)