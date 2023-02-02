package com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail

import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe

data class RecipeDetailState(
    val isLoading:Boolean=false,
    val recipe: Recipe?=null
)