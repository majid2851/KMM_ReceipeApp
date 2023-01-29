package com.codingwithmitch.kmm_learning_mitch.datasource.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory
{
    actual fun createDriver():SqlDriver{
        return NativeSqliteDriver(RecipeDB.Schema,"recipes.db")
    }
}