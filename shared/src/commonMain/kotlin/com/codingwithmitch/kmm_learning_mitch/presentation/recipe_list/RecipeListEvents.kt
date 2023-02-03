package com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list

sealed class RecipeListEvents
{
    object LoadRecipes:RecipeListEvents()

    object nextPage:RecipeListEvents()

    object newSearch:RecipeListEvents()

    data class onUpdateQuery(val query:String):RecipeListEvents()

    data class onSelectCategory(val category: FoodCategory):RecipeListEvents()

    object OnRemoveHeadMessageFromQueue:RecipeListEvents()


}