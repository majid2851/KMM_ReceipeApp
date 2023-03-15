package com.codingwithmitch.kmm_learning_mitch.domain.model



data class Recipe (
     val id: Int,
     val title: String,
     val publisher: String,
     val featuredImage: String,
     val rating: Int,
     val sourceUrl: String,
     val ingredients: List<String> = listOf(),
)