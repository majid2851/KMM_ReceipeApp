package com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list

import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.Queue
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.FoodCategory

actual data class RecipeListState(
    val isLoading:Boolean=false,
    val page:Int=1,
    val query:String="",
    val selectedCategory: FoodCategory?=null,
    val recipe:List<Recipe> = listOf(),
    val queue:Queue<GenericMessageInfo> = Queue(mutableListOf())
){




}