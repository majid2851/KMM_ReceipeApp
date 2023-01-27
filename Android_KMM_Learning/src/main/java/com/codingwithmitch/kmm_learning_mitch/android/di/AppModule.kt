package com.codingwithmitch.kmm_learning_mitch.android.di

import android.content.Context
import com.codingwithmitch.kmm_learning_mitch.android.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Scope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule
{
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app:Context):BaseApplication
    {
        return app as BaseApplication
    }




}