package com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list

import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe

data class RecipeStateList(
    val isLoading:Boolean=false,
    val page:Int=1,
    val query:String="",
    val recipe:List<Recipe> = listOf()
)