package com.codingwithmitch.kmm_learning_mitch.android.di

import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list.SearchRecipe
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
    fun provideSearchRecipe(recipeService: RecipeService):SearchRecipe
    {
        return SearchRecipe( recipeService)
    }









}