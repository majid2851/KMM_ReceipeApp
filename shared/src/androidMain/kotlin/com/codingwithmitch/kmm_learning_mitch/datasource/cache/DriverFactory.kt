package com.codingwithmitch.kmm_learning_mitch.datasource.cache

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(private val context: Context)
{
    actual fun createDriver():SqlDriver{
        return AndroidSqliteDriver(RecipeDB.Schema,context,"recipes.db")
    }




}