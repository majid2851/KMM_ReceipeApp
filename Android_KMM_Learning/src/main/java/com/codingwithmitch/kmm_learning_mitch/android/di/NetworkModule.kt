package com.codingwithmitch.kmm_learning_mitch.android.di

import com.codingwithmitch.kmm_learning_mitch.datasource.network.KtorClientFactory
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeServiceImpl
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeServiceImpl.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule
{
    @Singleton
    @Provides
    fun provideHttpClient():HttpClient
    {
        return KtorClientFactory().build()
    }


    @Singleton
    @Provides
    fun provideRecipeService(httpClient: HttpClient): RecipeService {
        return RecipeServiceImpl(httpClient,BASE_URL)
    }


}