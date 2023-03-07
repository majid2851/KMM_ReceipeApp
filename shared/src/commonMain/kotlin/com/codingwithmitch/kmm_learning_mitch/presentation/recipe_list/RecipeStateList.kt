package com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list

import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.Queue

data class RecipeStateList(
    val isLoading:Boolean=false,
    val page:Int=1,
    val query:String="",
    val selectedCategory:FoodCategory?=null,
    val recipe:List<Recipe> = listOf(),
    val queue:Queue<GenericMessageInfo> = Queue(mutableListOf())
){
    //constructor for swift ui
    constructor():this(
        isLoading=false,
        page=1,
        query="",
        recipe= listOf(),
        selectedCategory = null,
        queue = Queue(mutableListOf())



    )



}