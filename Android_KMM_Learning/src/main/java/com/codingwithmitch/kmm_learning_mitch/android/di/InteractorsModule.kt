package com.codingwithmitch.kmm_learning_mitch.android.di

import com.codingwithmitch.kmm_learning_mitch.datasource.cache.RecipeCache
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_detail.GetRecipe
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list.SearchRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule
{
    @Singleton
    @Provides
    fun provideSearchRecipe(recipeService: RecipeService,recipeCache: RecipeCache):SearchRecipes
    {
        return SearchRecipes( recipeService,recipeCache)
    }
    @Singleton
    @Provides
    fun provideGetRecipe(recipeCache: RecipeCache):GetRecipe
    {
        return GetRecipe(recipeCache)
    }








}