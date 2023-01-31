package com.codingwithmitch.kmm_learning_mitch.datasource.cache

import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import kotlinx.serialization.descriptors.StructureKind

interface RecipeCache
{
    fun insert(recipe:Recipe)

    fun insert(recipes:List<Recipe>)

    fun search(query:String,page:Int):List<Recipe>

    fun getAll(page: Int):List<Recipe>

    /*this throws is just because of ios client*/
    fun get(recipeId:Int):Recipe?






}