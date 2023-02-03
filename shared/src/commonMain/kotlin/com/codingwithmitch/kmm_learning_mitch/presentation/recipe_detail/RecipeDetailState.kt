package com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail

import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.Queue

data class RecipeDetailState(
    val isLoading:Boolean=false,
    val recipe: Recipe?=null,
    val queue: Queue<GenericMessageInfo> = Queue(mutableListOf())

)