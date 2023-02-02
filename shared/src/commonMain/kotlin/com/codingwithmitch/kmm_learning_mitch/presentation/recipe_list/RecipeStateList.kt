package com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list

import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.Queue

data class RecipeStateList(
    val isLoading:Boolean=false,
    val page:Int=1,
    val query:String="",
    val selectedCategory:FoodCategory?=null,
    val recipe:List<Recipe> = listOf(),
    val queue:Queue<String> = Queue(mutableListOf())
)