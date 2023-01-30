package com.codingwithmitch.kmm_learning_mitch.android.di

import com.codingwithmitch.kmm_learning_mitch.android.BaseApplication
import com.codingwithmitch.kmm_learning_mitch.datasource.cache.*
import com.codingwithmitch.kmm_learning_mitch.domain.util.DatetimeUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule
{
    @Singleton
    @Provides
    fun provideRecipeDatabase(context:BaseApplication):
        RecipeDB
    {
        return RecipeDatabaseFactory(driverFactory = DriverFactory(context)).createDatabase()
    }

    @Singleton
    @Provides
    fun provideRecipeCache(recipeDB: RecipeDB):RecipeCache
    {
        return RecipeCacheImpl(recipeDB, datetimeUtil = DatetimeUtil())
    }



}